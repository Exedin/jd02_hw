create database if not exists ListExpenses;
USE ListExpenses;
create table expenses (
	num int not null primary key,
	paydate date not null,
    receiver int not null,
    value dec not null);
insert into expenses values (1, '2011-5-10', 1, 20000);
insert into expenses values (2, '2011-5-10', 2, 94200);
insert into expenses values (3, '2011-5-11', 3, 10000);
insert into expenses values (4, '2011-5-11', 2, 12950);
create table receivers (
    num int not null,
	name varchar (255) not null);
ALTER TABLE `listexpenses`.`receivers` 
CHANGE COLUMN `name` `name` VARCHAR(255) CHARACTER SET 'utf8' NOT NULL ;
insert into receivers values (1, 'Интернет-провайдер "Соло"');
insert into receivers values (1, 'Гимермаркет "Корона"');
insert into receivers values (1, 'МТС');