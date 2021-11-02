
# VOC 서비스 구축

by Jisoo Jeong

- 해당 프로젝트를 실행하기 전, 
1. `yml파일의 username, password`를 확인해주세요
- 사용 중인 username과 password를 기재해주세요
2. `create database VOC_Project;` 를 콘솔에서 입력부탁드립니다
3. 아래의 [더미 데이터 생성을 위한 쿼리](https://github.com/hy6219/VOC_Project#%EB%8D%94%EB%AF%B8-%EB%8D%B0%EC%9D%B4%ED%84%B0)를 복사 및 붙여넣기 하여 콘솔에서 미리 생성부탁드립니다

😊확인해주셔서 감사합니다😊

## 진행하면서 배울 수 있었던 점

1. JPA 엔티티 → json 변환 시 발생하는 무한루프로 인한 StackOverflowError
- 참고한 자료: https://pasudo123.tistory.com/350
- 참고되는 부분과 참고를 하는 부분에 JsonManagedReference, JsonBackReference 어노테이션을 붙이기
2.  콘솔에 출력된 nested 메시지를 확인했을 때, Java8에서 jackson 사용 시 LocalDateTime 지원이 되지 않아서, `registerModule(new JavaTimeModule())` 을 붙여주어야 한다

## ✅ Database Design Work & Design Process

- [VOC 프로세스 및 필요한 정보 정리](https://github.com/hy6219/VOC_Project/blob/main/ERD%20%26%20Class%20Diagram/VOC%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4_%EC%A0%95%EB%A6%AC_%EC%A0%95%EC%A7%80%EC%88%98.md)
- [ERD 설계](https://github.com/hy6219/VOC_Project/blob/main/ERD%20%26%20Class%20Diagram/VOC_%EC%A0%95%EC%A7%80%EC%88%98_ERD%EC%84%A4%EA%B3%84.png)
- [테이블 스키마](https://github.com/hy6219/VOC_Project/blob/main/Table_Schema/VOC_jisooJeong.sql)
- [클래스 다이어그램](https://github.com/hy6219/VOC_Project/blob/main/ERD%20%26%20Class%20Diagram/VOC_%EC%A0%95%EC%A7%80%EC%88%98_%ED%81%B4%EB%9E%98%EC%8A%A4%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8_%EC%B4%88%EC%95%88.png)

## Source Code

[소스코드](https://github.com/hy6219/VOC_Project/tree/main/VOC_Project)

## jacoco 결과, API Documentation
- jacoco 검증은 JUnit을 이용한 통합테스트 진행 후 진행하였습니다

- [jacoco 테스트 커버리지 검증 결과](https://github.com/hy6219/VOC_Project/blob/main/jacoco_%ED%85%8C%EC%8A%A4%ED%8A%B8%EC%BB%A4%EB%B2%84%EB%A6%AC%EC%A7%80_%ED%99%95%EC%9D%B8.gif)
- [API 문서화 결과](https://github.com/hy6219/VOC_Project/blob/main/JisooJeong_TF_VOC_Swagger.gif)

## 더미 데이터
1. CS팀 직원 더미 데이터
```sql

insert into cs  
values(1,0,'김명수','123@456.com','Y','Y');  
insert into cs  
values(2,1,'김길동','133@456.com','Y','Y');  
insert into cs  
values(3,2,'나길동','223@456.com','Y','Y');  
insert into cs  
values(4,0,'다길동','153@456.com','N','Y');  
insert into cs  
values(5,1,'라길동','155@456.com','N','N');
```
2. 고객사 더미 데이터

```sql
select * from business;  
insert into business  
values(1,'TIMF0123','TIMF','123-4567-8901','가나다 라마바 사아자');  
insert into business  
values(2,'GF0123','GO FOWARD','133-4567-8901','가나다 라마바 사아자차');  
insert into business  
values(3,'AP0123','APP PUSH','122-4567-8901','가다다 라마바 사아자');  
insert into business  
values(4,'AA0123','AA BATTERY','123-4567-8902','가나라 라마바 사아자');  
insert into business  
values(5,'STEAK0123','STEAK','123-7567-8901','가나다 라마바 파자마');
```
3. 물품 더미 데이터

```sql
insert into product  
values(1,0,'화물1','A123','2021-05-05','Y',1);  
insert into product  
values(2,0,'화물2','A124','2021-05-05','Y',1);  
insert into product  
values(3,0,'화물3','A125','2021-05-05','Y',1);  
insert into product  
values(4,1,'FRESH1','F123','2021-05-10','N',2);  
insert into product  
values(5,1,'FRESH2','F124','2021-05-10','N',2);  
insert into product  
values(6,1,'FRESH3','F124','2021-05-10','N',2);  
insert into product  
values(7,2,'식자재1','FOOD123','2021-05-15','Y',3);  
insert into product  
values(8,2,'식자재2','FOOD124','2021-05-15','N',4);  
insert into product  
values(9,2,'식자재3','FOOD125','2021-05-15','Y',4);  
insert into product  
values(10,0,'화물15','A133','2021-05-20','Y',5);
```
4. 클레임 더미 데이터
```sql
insert into claim(claim_id, claim_type, claim_content, claim_reimburse, business_id)  
values(1,0,'배송지연','Y',1);  
insert into claim(claim_id, claim_type, claim_content, claim_reimburse, business_id)  
values(2,0,'배송지연','Y',2);  
insert into claim(claim_id, claim_type, claim_content, claim_reimburse, business_id)  
values(3,2,'식자재 물품 건수 부족','Y',3);  
insert into claim(claim_id, claim_type, claim_content, claim_reimburse, business_id)  
values(4,1,'신선식품 상태 불량','Y',4);  
insert into claim(claim_id, claim_type, claim_content, claim_reimburse, business_id)  
values(5,0,'배송지연','Y',5);
```
5. Retail 더미 데이터
```sql
insert into retail(retail_id, retail_name, ceo, retail_pubtel, retail_addr)  
values(1,'-','-','-','-');  
insert into retail(retail_id, retail_name, ceo, retail_pubtel, retail_addr)  
values(2,'HELLO','감자빵','123-456-789','다다다 라라라 마마마');  
insert into retail(retail_id, retail_name, ceo, retail_pubtel, retail_addr)  
values(3,'CAKE','케이크','125-456-789','다다 라라라 마마마');  
insert into retail(retail_id, retail_name, ceo, retail_pubtel, retail_addr)  
values(4,'HAMBURGER','햄버거','223-456-789','파다다 라라라 마마마');  
insert into retail(retail_id, retail_name, ceo, retail_pubtel, retail_addr)  
values(5,'HI','하이테크','133-456-789','다다카 라라라 마마마');  
insert into retail(retail_id, retail_name, ceo, retail_pubtel, retail_addr)  
values(6,'ABC','ABC','153-456-789','다다다 파라라 마마마');
```
6. Driver 더미데이터
```sql
insert into driver(driver_id, driver_name, driver_tel, driver_addr, driver_salary, driver_clsal, retail_id)  
values (1,'-','-','-',0,0,1);  
insert into driver(driver_id, driver_name, driver_tel, driver_addr, driver_salary, driver_clsal, retail_id)  
values (2,'고구마빵','111-222-333','라마바 사아자 차카타',3000000,3000000,2);  
insert into driver(driver_id, driver_name, driver_tel, driver_addr, driver_salary, driver_clsal, retail_id)  
values (3,'불고기피자','113-222-333','라바바 사아자 차카타',3000000,3000000,2);  
insert into driver(driver_id, driver_name, driver_tel, driver_addr, driver_salary, driver_clsal, retail_id)  
values (4,'탕수육','311-222-333','라바 사아자 차카타',3000000,3000000,2);  
insert into driver(driver_id, driver_name, driver_tel, driver_addr, driver_salary, driver_clsal, retail_id)  
values (5,'화전','333-222-333','라마바 사아자 차타타',3000000,3000000,3);  
insert into driver(driver_id, driver_name, driver_tel, driver_addr, driver_salary, driver_clsal, retail_id)  
values (6,'양파빵','113-225-333','파바파 사아자 차카타',3000000,3000000,3);  
insert into driver(driver_id, driver_name, driver_tel, driver_addr, driver_salary, driver_clsal, retail_id)  
values (7,'감자전','311-222-333','라가바 사아자 차카타',3000000,3000000,4);  
insert into driver(driver_id, driver_name, driver_tel, driver_addr, driver_salary, driver_clsal, retail_id)  
values (8,'카스테라','315-222-333','라바바 사아자 차카타',3000000,3000000,5);  
insert into driver(driver_id, driver_name, driver_tel, driver_addr, driver_salary, driver_clsal, retail_id)  
values (9,'치킨','311-222-363','파파바 사아자 차카타',3000000,3000000,6);
```

7. VOC 더미데이터
```sql
insert into voc(voc_id, reason_chk, driver_chk, driver_pchk, driver_disagree, voc_regdate, voc_recent, eid, claim_id,retail_id,driver_id)  
values (1,'-1','-1','-1','N',SYSDATE(),SYSDATE(),1,1,1,1);  
insert into voc(voc_id, reason_chk, driver_chk, driver_pchk, driver_disagree, voc_regdate, voc_recent, eid, claim_id,retail_id,driver_id)  
values (2,'-1','-1','-1','N',SYSDATE(),SYSDATE(),2,2,1,1);  
insert into voc(voc_id, reason_chk, driver_chk, driver_pchk, driver_disagree, voc_regdate, voc_recent, eid, claim_id,retail_id,driver_id)  
values (3,'-1','-1','-1','N',SYSDATE(),SYSDATE(),3,3,1,1);  
insert into voc(voc_id, reason_chk, driver_chk, driver_pchk, driver_disagree, voc_regdate, voc_recent, eid, claim_id,retail_id,driver_id)  
values (4,'-1','-1','-1','N',SYSDATE(),SYSDATE(),1,4,1,1);  
insert into voc(voc_id, reason_chk, driver_chk, driver_pchk, driver_disagree, voc_regdate, voc_recent, eid, claim_id,retail_id,driver_id)  
values (5,'-1','-1','-1','N',SYSDATE(),SYSDATE(),2,5,1,1);
```

8. VOC 히스토리 더미데이터
```sql
insert into voc_hist(hist_id, hist_regdate, voc_id)  
values (1,sysdate(),1);  
insert into voc_hist(hist_id, hist_regdate, voc_id)  
values (2,sysdate(),2);  
insert into voc_hist(hist_id, hist_regdate, voc_id)  
values (3,sysdate(),3);  
insert into voc_hist(hist_id, hist_regdate, voc_id)  
values (4,sysdate(),4);  
insert into voc_hist(hist_id, hist_regdate, voc_id)  
values (5,sysdate(),5);
```
9. 배상 처리 데이터
```sql
update voc  
set reason_chk=1,voc_target='R',voc_penalty='조사완료',voc_reim='100000',  
    driver_chk='-1',driver_pchk='-1',driver_disagree='-1'  
where voc_id=1;  
  
insert into voc_hist  
values (6,sysdate(),1);   
  
insert into reim(reim_id, reim_date, voc_id)  
values(1,sysdate(),1);  
  
##배상2  
update voc  
set reason_chk=1,voc_target='D',voc_penalty='조사완료',voc_reim='100000',  
       driver_chk='0',driver_pchk='0',driver_disagree='N'  
where voc_id=2;  
  
insert into voc_hist  
values (7,sysdate(),2);  
  
insert into reim(reim_id, reim_date, voc_id)  
values(2,sysdate(),2);
``` 

10. 검토 처리 더미 데이터
```sql
update voc  
set reason_chk=1,voc_target='D',voc_penalty='조사중',voc_reim='100000',  
       driver_chk='0',driver_pchk='0',driver_disagree='Y'  
where voc_id=3;  
  
insert into voc_hist  
values (8,sysdate(),3);  
  
insert into review(review_id, review_regdate, voc_id)  
values (1,sysdate(),3);  
  
update voc  
set reason_chk=1,voc_target='D',voc_penalty='조사중',voc_reim='100000',  
       driver_chk='0',driver_pchk='0',driver_disagree='Y'  
where voc_id=4;  
  
insert into voc_hist  
values (9,sysdate(),4);  
  
insert into review(review_id, review_regdate, voc_id)  
values (2,sysdate(),4);
```

## jacoco 결과지 위치

만약 다운로드를 받으셨다면, /VOC_Project/build/reports/tests/test/index.html를 확인해주시면 감사하겠습니다!

## 커밋 메시지 템플릿
- 아래의 커밋 메시지 템플릿 설명을 참조하여 진행하였습니다

https://junwoo45.github.io/2020-02-06-commit_template/
