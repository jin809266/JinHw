# JinHw
#### src/main/resources/application.yml
spring:
  h2:
    console:
      enabled: true
  datasource:
    initialization-mode: always
    url: jdbc:h2:mem:coin;DB_CLOSE_DELAY=-1;
    driver-class-name: org.h2.Driver
    username: sa
    password: sa
    platform: h2
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: none
      naming-strategy: org.hibernate.cfg.ImprovedNamingStrategy

### src/main/resources/schema-h2.sql

DROP TABLE IF EXISTS COINDESK;

CREATE TABLE COINDESK (
    COIN_CODE VARCHAR(250) NOT NULL PRIMARY KEY ,
    COIN_RATE DECIMAL(10, 4) ,
    CREATE_TIME TIMESTAMP,
    UPDATE_TIME TIMESTAMP
);

DROP TABLE IF EXISTS COINDESKMAP;

CREATE TABLE COINDESKMAP (
    COIN_CODE VARCHAR(250) NOT NULL PRIMARY KEY ,
    COIN_NAME VARCHAR(250) NOT NULL ,
    COIN_RATE DECIMAL(10, 4) ,
    CREATE_TIME TIMESTAMP,
    UPDATE_TIME TIMESTAMP
);


### src/main/resources/data-h2.sql

INSERT INTO COINDESK (COIN_CODE,COIN_RATE,CREATE_TIME,UPDATE_TIME) VALUES ('USD',31794.7751,{ts '2021-07-22 18:47:52.69'},{ts '2021-07-22 18:47:52.69'});
INSERT INTO COINDESK (COIN_CODE,COIN_RATE,CREATE_TIME,UPDATE_TIME) VALUES ('GBP',23025.331,{ts '2021-07-22 18:47:52.69'},{ts '2021-07-22 18:47:52.69'});
INSERT INTO COINDESK (COIN_CODE,COIN_RATE,CREATE_TIME,UPDATE_TIME) VALUES ('EUR',6939.6175,{ts '2021-07-22 18:47:52.69'},{ts '2021-07-22 18:47:52.69'});
INSERT INTO COINDESKMAP (COIN_CODE,COIN_NAME,CREATE_TIME,UPDATE_TIME) VALUES ('USD','美金',{ts '2021-07-21 18:47:52.69'},{ts '2021-07-21 18:47:52.69'});
INSERT INTO COINDESKMAP (COIN_CODE,COIN_NAME,CREATE_TIME,UPDATE_TIME) VALUES ('GBP','英鎊',{ts '2021-07-21 18:47:52.69'},{ts '2021-07-21 18:47:52.69'});
INSERT INTO COINDESKMAP (COIN_CODE,COIN_NAME,CREATE_TIME,UPDATE_TIME) VALUES ('EUR','歐元',{ts '2021-07-21 18:47:52.69'},{ts '2021-07-21 18:47:52.69'});
