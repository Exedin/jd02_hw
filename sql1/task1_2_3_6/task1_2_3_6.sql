#Создание таблицы
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
    num int not null primary key,
	name varchar (255) not null);
ALTER TABLE `listexpenses`.`receivers` 
CHANGE COLUMN `name` `name` VARCHAR(255) CHARACTER SET 'utf8' NOT NULL ;

#запросы для task1
insert into receivers values (1, 'Интернет-провайдер "Соло"');
insert into receivers values (2, 'Гимермаркет "Корона"');
insert into receivers values (3, 'МТС');

#запрос для task2
select expenses.num, paydate, name, value from expenses,receivers where receiver=receivers.num and value>10000 Order by expenses.num;
insert into expenses values (5, '2011-5-12', 2, 9999);
update expenses set value=2999 where num=5;
SET SQL_SAFE_UPDATES = 0;

#запрос task3 заполним таблицу expenses
delete from expenses where value < 3000;
insert into expenses values (5, '2011-5-26', 3, 150000);
insert into expenses values (6, '2011-5-26', 1, 5000);
insert into expenses values (7, '2011-5-27', 2, 40000);

#все платежи
select expenses.num, paydate, name, value from expenses,receivers where receiver=receivers.num Order by expenses.num;


#запросы task6-1 - список получателей и сумма платежей по каждому из них
select receivers.num, name, SUM(value) from expenses, receivers where receivers.num=receiver group by receiver;

#запросы для построения task6-2
#выведем наибольший платеж
select MAX(value) from expenses;
#выведем наибольший платеж с датой и номером платежа
select num, paydate, value from expenses  where value=(select MAX(value) from expenses); 
#выведем список платежей за день, когда был нибольший платеж
select num, paydate, value from expenses where paydate=(select paydate from expenses  where value=(select MAX(value) from expenses));
#запрос task6-2 окончательный - выведем сумму платежей за тот день, когда был наибольший платеж
select paydate, SUM(value)  from expenses where paydate=(select paydate from expenses  where value=(select MAX(value) from expenses));

#запросы для построения task6-3
#выведем сумму платежей по дням по возрастанию
select paydate, SUM(value) as sum from expenses group by paydate order by sum desc;
#вывуедем дату когда была максимальная сумма платежей и сумму за этот день
select paydate, SUM(value) as sum from expenses group by paydate order by sum desc limit 1;
#выведем дату когда была максимальная сумма платежей
select x.paydate from (select paydate, SUM(value) as sum from expenses group by paydate order by sum desc limit 1) x;
#выведем все платежи за дату, когда сумма платежей была максимальная
select num, paydate, value from expenses where paydate=(select x.paydate from (select paydate, SUM(value) as sum from expenses group by paydate order by sum desc limit 1) x);
#запрос task6-3 окончательный - выведем максимальный платеж за день, когда сумма платежей была максимальной
select num, paydate, value from expenses where paydate=(select x.paydate from (select paydate, SUM(value) as sum from expenses group by paydate order by sum desc limit 1) x)  order by value desc limit 1;

