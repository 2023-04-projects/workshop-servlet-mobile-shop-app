create Schema 2024_batch;
use 2024_batch;
create table stock(id int auto_increment primary key, type varchar(200), qty  int);
create table mobile(product_brand varchar(50),product_price double,product_model varchar(50),arrived_date_time datetime);
create table charger(brand varchar(50),price double,model varchar(50),arrived_date_time datetime);
create table powerbank(brand varchar(50),price double,model varchar(50),arrived_date_time datetime);
create table headset(brand varchar(50),price double,model varchar(50),arrived_date_time datetime);
create table backcover(brand varchar(50),price double,model varchar(50),arrived_date_time datetime);