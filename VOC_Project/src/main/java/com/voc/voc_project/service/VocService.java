package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.*;
import com.voc.voc_project.domain.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class VocService {
    @Autowired
    private VOCRepository vocRepository;
    @Autowired
    private VocHistRepository vocHistRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReimRepository reimRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RetailRepository retailRepository;

    public void recordReasonChk(Long vocId, String target,
                                int reimTot, String driverChk,
                                String penaltyChk, String disagree,
                               Long retailId, Long driverId){

        VOC voc=vocRepository.findById(vocId).orElseThrow(RuntimeException::new);
        System.out.println(voc);
        voc.setTarget(target);
        voc.setReimTot(reimTot);

        Retail retail=retailRepository.findById(retailId).orElseThrow(RuntimeException::new);
        Driver driver=driverRepository.findById(driverId).orElseThrow(RuntimeException::new);

        //1.만약 retail이나 driver가 비워져 있다면 조사중인것
        //2.1외의 기사확인여부가 -1이던지, 다른 필드값들이 null이던지는 모두 조사중인것
        //그럼에도 이의제기여부필드만 Y이라면 검토건처리
        //3.retail이나 driver가 비워져 있지 않고&&모든 필드가 null이 아니면 조사완료이고-->
        //그때에는 클레임의 배상요청여부가 Y이면 배상테이블로 이동시키기
        String penalty="조사중";
        String reasonChk="0";
        boolean review=false;
       if(retailId!=null || driverId!=null){
           if(target.equals("R")){
               penalty="조사완료";
               reasonChk="1";
           }
            if(target.equals("D")&&driverChk.equals("0") && penaltyChk.equals("0") && disagree.equals("N")){
                penalty="조사완료";
                reasonChk="1";
            }
            if(target.equals("D")&&driverChk.equals("0") && penaltyChk.equals("0") && disagree.equals("Y")){
                penalty="조사중";
                reasonChk="0";
                review=true;
            }
       }

       //미연의 상황에 대비해서 한번더 체크
       if(reasonChk.equals("0") || penalty.equals("조사중")){
           penalty="조사중";
           reasonChk="0";
       }
       voc.setReasonChk(reasonChk);
       voc.setPenalty(penalty);
       voc.setDisagree(disagree);
       voc.setReimTot(reimTot);
       voc.setDriver(driver);
       voc.setRetail(retail);
       voc.setTarget(target);
       voc.setPenaltyChk(penaltyChk);
       vocRepository.save(voc);
       Hist hist=new Hist();
       hist.setVoc(voc);
       vocHistRepository.save(hist);

       //검토테이블
        if(review){
            Review review1=new Review();
            review1.setVoc(voc);
            reviewRepository.save(review1);
            log.info("[검토진행 필요]");
        }else{
            //배상처리
            //먼저 클레임필드에서 배상요청을 했는지 확인하고,
            //target이 "R"이면 바로 배상테이블에 적용


            //target이 "D"이면 배상테이블에 적용하고,
            //기사님 클레임 월급을 조정
            Claim claim=voc.getClaim();
            String flag=claim.getReimburseChk();
            if(flag.equals("Y")){
                //운송사 책임과 기사님 책임 모두 배상테이블에는 적용해야 함
                Reim reim=new Reim();
                reim.setVoc(voc);
                reimRepository.save(reim);
                log.info("[보상체계 진행]");
                if(target.equals("D") && driver!=null){
                    //기사님 월급 조정
                    driver.setClSal(driver.getOriginSal()-reimTot);
                    //정보저장
                    driverRepository.save(driver);
                }
            }

        }
    }


    public ResponseEntity<ArrayList<VOC>> searchAllVoc(){
        ArrayList<VOC> list= (ArrayList<VOC>) vocRepository.findAll();
        ResponseEntity<ArrayList<VOC>> response=ResponseEntity.ok(list);
        return response;
    }
}
