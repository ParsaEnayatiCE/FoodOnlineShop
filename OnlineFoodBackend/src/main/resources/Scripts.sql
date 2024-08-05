CREATE DATABASE IF NOT EXISTS FoodShopDB;
USE FoodShopDB;


CREATE TABLE USERS (
                       ID INT AUTO_INCREMENT PRIMARY KEY,
                       USER_NAME VARCHAR(100) NOT NULL,
                       PASSWORD VARCHAR(100) NOT NULL,
                       EMAIL VARCHAR(300) NOT NULL,
                       PHONE_NUMBER VARCHAR(100) NOT NULL,
                       USER_TYPE VARCHAR(100) NOT NULL,
                       IS_CONFIRMED_BY_ADMIN BOOLEAN NOT NULL
);

CREATE TABLE CUSTOMER (
                          ID INT AUTO_INCREMENT PRIMARY KEY,
                          FIRST_NAME VARCHAR(100) NOT NULL,
                          LAST_NAME VARCHAR(100) NOT NULL,
                          MIDDLE_NAME VARCHAR(300),
                          ADDRESS VARCHAR(300) NOT NULL,
                          USER_ID INT NOT NULL,
                          FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);

CREATE TABLE RESTAURANT (
                            ID INT AUTO_INCREMENT PRIMARY KEY,
                            NAME VARCHAR(100) NOT NULL,
                            ADDRESS VARCHAR(300) NOT NULL,
                            USER_ID INT NOT NULL,
                            FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);

CREATE TABLE DELIVERY (
                          ID INT AUTO_INCREMENT PRIMARY KEY,
                          FIRST_NAME VARCHAR(100) NOT NULL,
                          LAST_NAME VARCHAR(100) NOT NULL,
                          MIDDLE_NAME VARCHAR(300),
                          IS_ACTIVE BOOLEAN NOT NULL,
                          USER_ID INT NOT NULL,
                          RESTAURANT_ID INT NOT NULL,
                          RATING INT,
                          FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
                          FOREIGN KEY (RESTAURANT_ID) REFERENCES RESTAURANT(ID)
);


CREATE TABLE MENU (
                      ID INT AUTO_INCREMENT PRIMARY KEY,
                      NAME VARCHAR(100) NOT NULL,
                      RESTAURANT_ID INT NOT NULL,
                      FOREIGN KEY (RESTAURANT_ID) REFERENCES RESTAURANT(ID)
);


CREATE TABLE MENU_ITEM (
                           ID INT AUTO_INCREMENT PRIMARY KEY,
                           NAME VARCHAR(100) NOT NULL,
                           DESCRIPTION VARCHAR(100) NOT NULL,
                           PRICE DECIMAL(10, 2) NOT NULL,
                           MENU_ID INT NOT NULL,
                           FOREIGN KEY (MENU_ID) REFERENCES MENU(ID)
);

CREATE TABLE REVIEW (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        TEXT VARCHAR(200) NOT NULL,
                        SCORE INT NOT NULL,
                        DATE_SUBMIT DATE NOT NULL,
                        ORDER_ID INT NOT NULL
);

CREATE TABLE ORDERS (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        STATUS VARCHAR(100) NOT NULL,
                        DESTINATION_ADDRESS VARCHAR(300) NOT NULL,
                        DATE_CREATED DATE NOT NULL,
                        RESTAURANT_ID INT NOT NULL,
                        CUSTOMER_ID INT NOT NULL,
                        REVIEW_ID INT,
                        DELIVERY_ID INT,
                        FOREIGN KEY (RESTAURANT_ID) REFERENCES RESTAURANT(ID),
                        FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(ID),
                        FOREIGN KEY (REVIEW_ID) REFERENCES REVIEW(ID),
                        FOREIGN KEY (DELIVERY_ID) REFERENCES DELIVERY(ID)
);

CREATE TABLE ORDER_ITEM (
                            ID INT AUTO_INCREMENT PRIMARY KEY,
                            COUNT INT NOT NULL,
                            ORDER_ID INT NOT NULL,
                            MENU_ITEM_ID INT NOT NULL,
                            FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ID),
                            FOREIGN KEY (MENU_ITEM_ID) REFERENCES MENU_ITEM(ID)
);
