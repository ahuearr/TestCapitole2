CREATE TABLE PRICES (
  ID INTEGER PRIMARY KEY,
  BRAND_ID INTEGER NOT NULL,
  START_DATE VARCHAR(100) NOT NULL,
  END_DATE VARCHAR(100) NOT NULL,
  PRICE_LIST INTEGER NOT NULL,
  PRODUCT_ID INTEGER NOT NULL,
  PRIORITY INTEGER NOT NULL,
  PRICE DECIMAL(9,2) NOT NULL,
  CURR VARCHAR(3) NOT NULL);