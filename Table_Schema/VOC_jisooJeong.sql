DROP TABLE IF EXISTS `CLAIM`;

CREATE TABLE `CLAIM` (
                         `CLAIM_ID`	BIGINT	NOT NULL COMMENT '클레임 ID',
                         `CLAIM_TYPE`	INT	NULL COMMENT '클레임 분류[0:고객변심,1:배송지연,2:상품문제]',
                         `CLAIM_CONTENT`	VARCHAR(2000)	NULL COMMENT '클레임 내용',
                         `CLAIM_REIMBURSE`	VARCHAR(5)	NULL COMMENT '배상요청여부',
                         `BUSINESS_ID`	BIGINT	NOT NULL COMMENT '고객사 ID',
                         CHECK (`CLAIM_TYPE` IN (0,1,2)),
                         CHECK (`CLAIM_REIMBURSE` IN('N','Y'))
);
ALTER TABLE CLAIM COMMENT='클레임';

DROP TABLE IF EXISTS `BUSINESS`;

CREATE TABLE `BUSINESS` (
                            `BUSINESS_ID`	BIGINT	NOT NULL COMMENT '고객사 ID',
                            `BUSINESS_CODE`	VARCHAR(2000)	NULL COMMENT '고객사 코드',
                            `BUSINESS_NAME`	VARCHAR(2000)	NULL COMMENT '고객사 이름',
                            `BUSINESS_TEL`	VARCHAR(2000)	NULL COMMENT '고객사 연락처',
                            `BUSINESS_ADDR`	VARCHAR(2000)	NULL COMMENT '고객사 주소'
);
ALTER TABLE BUSINESS COMMENT='고객사';

DROP TABLE IF EXISTS `PRODUCT`;

CREATE TABLE `PRODUCT` (
                           `PRODUCT_ID`	BIGINT	NOT NULL COMMENT '물품 ID',
                           `PRODUCT_TYPE`	INT	NULL COMMENT '물품 분류',
                           `PRODUCT_NAME`	VARCHAR(2000)	NULL COMMENT '물품명',
                           `PRODUCT_CODE`	VARCHAR(2000)	NULL COMMENT '물품코드',
                           `PRODUCT_RECDATE`	TIMESTAMP	NULL COMMENT '거래일자',
                           `PRODUCT_DEPOSIT_CHK`	VARCHAR(5)	NULL COMMENT '입금확인여부',
                           `BUSINESS_ID`	BIGINT	NOT NULL COMMENT '고객사 ID',
                           CHECK (`PRODUCT_TYPE` IN(0,1,2))
);
ALTER TABLE PRODUCT COMMENT='물품';

DROP TABLE IF EXISTS `RETAIL`;

CREATE TABLE `RETAIL` (
                          `RETAIL_ID`	BIGINT	NOT NULL COMMENT '운송사 ID',
                          `RETAIL_NAME`	VARCHAR(2000)	NULL COMMENT '운송사 이름',
                          `CEO`	VARCHAR(2000)	NULL COMMENT '대표자 이름',
                          `RETAIL_PUBTEL`	VARCHAR(2000)	NULL COMMENT '운송사 연락처',
                          `RETAIL_ADDR`	VARCHAR(2000)	NULL COMMENT '운송사 주소'
);
ALTER TABLE RETAIL COMMENT='운송사';
DROP TABLE IF EXISTS `DRIVER`;

CREATE TABLE `DRIVER` (
                          `DRIVER_ID`	BIGINT	NOT NULL COMMENT '기사 ID',
                          `DRIVER_NAME`	VARCHAR(2000)	NULL COMMENT '기사 이름',
                          `DRIVER_TEL`	VARCHAR(2000)	NULL COMMENT '기사 연락처',
                          `DRIVER_ADDR`	VARCHAR(2000)	NULL COMMENT '기사 주소',
                          `DRIVER_SALARY`	INT	NULL COMMENT '기사 월급',
                          `DRIVER_CLSAL`	INT	NULL COMMENT '클레임으로 인한 월급',
                          `RETAIL_ID`	BIGINT	NOT NULL COMMENT '운송사 ID'
);
ALTER TABLE DRIVER COMMENT='기사';
DROP TABLE IF EXISTS `VOC`;

CREATE TABLE `VOC` (
                       `VOC_ID`	BIGINT	NOT NULL COMMENT 'VOC ID',
                       `REASON_CHK`	VARCHAR(5)	NULL COMMENT '귀책 조사 여부',
                       `VOC_TARGET`	VARCHAR(5)	NULL COMMENT '귀책 담당자[R:운송사, D: 기사]',
                       `VOC_PENALTY`	VARCHAR(2000)	NULL COMMENT '패널티 내용',
                       `VOC_REIM`	INT	NULL COMMENT '보상(배상) 금액',
                       `DRIVER_CHK`	VARCHAR(5)	NULL COMMENT '기사 확인 여부',
                       `DRIVER_PCHK`	VARCHAR(5)	NULL COMMENT '기사 패널티 확인 여부',
                       `DRIVER_DISAGREE`	VARCHAR(5)	NULL COMMENT '이의 제기 여부',
                       `VOC_REGDATE`	TIMESTAMP	NULL COMMENT '등록일',
                       `VOC_RECENT`	TIMESTAMP	NULL COMMENT '최근 수정일',
                       `EID`	BIGINT	NOT NULL,
                       `CLAIM_ID`	BIGINT	NOT NULL,
                       `RETAIL_ID`	BIGINT	NOT NULL COMMENT '운송사 ID',
                       `DRIVER_ID`	BIGINT	NOT NULL COMMENT '기사 ID',
    -- -1: 귀책사유 조사하지 않았음 0: 귀책사유 조사하는 중, 1: 귀책사유 조사 완료
                       CHECK (`REASON_CHK` IN('-1','0','1')),
    -- R: 운송사 책임 D: 기사 책임
                       CHECK (`VOC_TARGET` IN('R','D')),
    -- -1 : 기사님 학인하지 않은 상태 0: 확인한 상태
                       CHECK (`DRIVER_CHK` IN('-1','0')),
                       CHECK (`DRIVER_PCHK` IN('-1','0')),
    -- -1: 확인하기 전이라서 이의 제기 여부 확인이 어려운 경우
    -- N: 이의 제기X
    -- Y: 이의 제기
                       CHECK (`DRIVER_DISAGREE` IN ('-1','N','Y'))
);
ALTER TABLE VOC COMMENT='VOC 기록';
DROP TABLE IF EXISTS `CS`;

CREATE TABLE `CS` (
                      `EID`	BIGINT	NOT NULL COMMENT '직원 ID',
                      `EPART`	INT	NULL COMMENT '클레임 분류[0:고객변심,1:배송지연,2:상품문제]',
                      `ENAME`	VARCHAR(2000)	NULL COMMENT '직원 이름',
                      `EMAIL`	VARCHAR(2000)	NULL COMMENT '직원 이메일',
                      `AFFORD`	VARCHAR(100)	NULL COMMENT '클레임 업무 여유 여부',
                      `AT_WORK`	VARCHAR(5)	NULL COMMENT '근무 여부',
                      CHECK (`EPART` IN(0,1,2))
);
ALTER TABLE CS COMMENT='영업지원부 고객사 관리팀 직원 배치 정보';
DROP TABLE IF EXISTS `VOC_HIST`;

CREATE TABLE `VOC_HIST` (
                            `HIST_ID`	BIGINT	NOT NULL COMMENT 'HIST ID',
                            `HIST_REGDATE`	TIMESTAMP	NULL COMMENT '히스토리 등록일자',
                            `VOC_ID`	BIGINT	NOT NULL
);
ALTER TABLE VOC_HIST COMMENT='VOC 히스토리 테이블';
DROP TABLE IF EXISTS `REIM`;

CREATE TABLE `REIM` (
                        `REIM_ID`	BIGINT	NOT NULL COMMENT '보상 ID',
                        `REIM_DATE`	TIMESTAMP	NULL COMMENT '보상 등록일자',
                        `VOC_ID`	BIGINT	NOT NULL
);
ALTER TABLE REIM COMMENT='배상 처리';
DROP TABLE IF EXISTS `REVIEW`;

CREATE TABLE `REVIEW` (
                          `REVIEW_ID`	BIGINT	NOT NULL COMMENT '검토 ID',
                          `REVIEW_REGDATE`	TIMESTAMP	NULL COMMENT '검토건 등록일자',
                          `VOC_ID`	BIGINT	NOT NULL
);
ALTER TABLE REVIEW COMMENT='검토 테이블';
ALTER TABLE `CLAIM` ADD CONSTRAINT `PK_CLAIM` PRIMARY KEY (
                                                           `CLAIM_ID`
    );

ALTER TABLE `BUSINESS` ADD CONSTRAINT `PK_BUSINESS` PRIMARY KEY (
                                                                 `BUSINESS_ID`
    );

ALTER TABLE `PRODUCT` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
                                                               `PRODUCT_ID`
    );

ALTER TABLE `RETAIL` ADD CONSTRAINT `PK_RETAIL` PRIMARY KEY (
                                                             `RETAIL_ID`
    );

ALTER TABLE `DRIVER` ADD CONSTRAINT `PK_DRIVER` PRIMARY KEY (
                                                             `DRIVER_ID`
    );

ALTER TABLE `VOC` ADD CONSTRAINT `PK_VOC` PRIMARY KEY (
                                                       `VOC_ID`
    );

ALTER TABLE `CS` ADD CONSTRAINT `PK_CS` PRIMARY KEY (
                                                     `EID`
    );

ALTER TABLE `VOC_HIST` ADD CONSTRAINT `PK_VOC_HIST` PRIMARY KEY (
                                                                 `HIST_ID`
    );

ALTER TABLE `REIM` ADD CONSTRAINT `PK_REIM` PRIMARY KEY (
                                                         `REIM_ID`
    );

ALTER TABLE `REVIEW` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
                                                             `REVIEW_ID`
    );
ALTER  TABLE `VOC` ADD CONSTRAINT `FK_VOC_CLAIM` FOREIGN KEY (
                                                               `CLAIM_ID`
    )  REFERENCES CLAIM(CLAIM_ID);