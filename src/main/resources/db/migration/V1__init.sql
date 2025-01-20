DROP TABLE PRICE IF EXISTS;

CREATE TABLE PRICE (
    PRICE_LIST INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    BRAND_ID   INT NOT NULL,
    START_DATE TIMESTAMP NOT NULL,
    END_DATE   TIMESTAMP NOT NULL,
    PRODUCT_ID INT NOT NULL,
    PRIORITY   INT NOT NULL,
    PRICE      NUMERIC(10, 2) NOT NULL,
    CURR       VARCHAR(10)
);


INSERT INTO PRICE (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1, parsedatetime('2020-06-14-00.00.00','yyyy-MM-dd-HH.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'), 35455, 0, 35.50, 'EUR');
INSERT INTO PRICE (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1, parsedatetime('2020-06-14-15.00.00','yyyy-MM-dd-HH.mm.ss'), parsedatetime('2020-06-14-18.30.00', 'yyyy-MM-dd-HH.mm.ss'), 35455, 1, 25.45, 'EUR');
INSERT INTO PRICE (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1, parsedatetime('2020-06-15-00.00.00','yyyy-MM-dd-HH.mm.ss'), parsedatetime('2020-06-15-11.00.00', 'yyyy-MM-dd-HH.mm.ss'), 35455, 1, 30.50, 'EUR');
INSERT INTO PRICE (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1, parsedatetime('2020-06-15-16.00.00','yyyy-MM-dd-HH.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'), 35455, 1, 38.95, 'EUR');