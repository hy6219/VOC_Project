
# VOC 서비스 구축

by Jisoo Jeong
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
```
5. Retail 더미 데이터
```sql
insert into retail(retail_id, retail_name, ceo, retail_pubtel, retail_addr)  
values(1,'-','-','-','-');  
insert into retail(retail_id, retail_name, ceo, retail_pubtel, retail_addr)  
values(2,'HELLO','감자빵','123-456-789','다다다 라라라 마마마');
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
```

7. VOC 더미데이터
```sql
insert into voc(voc_id, reason_chk, driver_chk, driver_pchk, driver_disagree, voc_regdate, voc_recent, eid, claim_id,retail_id,driver_id)  
values (1,'-1','-1','-1','N',SYSDATE(),SYSDATE(),1,1,1,1);
```

8. VOC 히스토리 더미데이터
```sql
insert into voc_hist(hist_id, hist_regdate, voc_id)  
values (1,sysdate(),1);
```
