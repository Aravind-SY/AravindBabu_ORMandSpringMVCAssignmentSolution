create database customersdatabase;
use customersdatabase;

create table Customers
(
id int primary key auto_increment,
firstname varchar(50),
lastname varchar(50),
email varchar(50)
);
insert into Customers(firstname,lastname,email)
values('Harshit','Choudary','Harshit@greatlearning.com');