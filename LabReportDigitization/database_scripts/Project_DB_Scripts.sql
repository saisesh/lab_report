# create database lab_report_digitization;
# show databases;
# drop database lab_report_digitization;
# use lab_report_digitization;
# CREATE TABLE customer_login (uname VARCHAR(20) NOT NULL, password VARCHAR(20) NOT NULL, token VARCHAR(100), CONSTRAINT PK_CUSTOMER_LOGIN PRIMARY KEY (uname));
# CREATE TABLE customer_profile (uname VARCHAR(20) NOT NULL REFERENCES customer_login(uname), firstname VARCHAR(20), lastname VARCHAR(100), email VARCHAR(20), age INT, phone LONG);
# INSERT INTO customer_profile (uname, firstname, lastname, email, age, phone) VALUES ('sai','sai','sai', 'sai@gmail.com', 19, 7879879879);
# DROP TABLE customer_profile;
# DROP TABLE customer_login;
# INSERT INTO customer_login (uname,password, token) VALUES ('sai','sai','');
# INSERT INTO customer_login (uname,password, token) VALUES ('praveen','praveen','');
# SELECT * FROM customer_login;
# SELECT * FROM customer_login WHERE uname='sai';

# SELECT * FROM customer_profile;

# SELECT *FROM customer_profile LEFT JOIN customer_login ON customer_profile.uname = customer_login.uname 3where customer_login.token='sFwd85Cxvi2dMHYPi7270ip';