#insert into test1.staff (FIO) values ('санек');
#insert into test1.staff (FIO) values ('леха');
SELECT * FROM test1.staff;
#insert into test1.clients (FIO,telephone) values ('антонов ден','6546546846');
#insert into test1.clients (FIO,telephone) values ('царь','16548684');
SELECT * FROM test1.clients;
#insert into test1.category (category_name) values ('компьютер');
#insert into test1.category (category_name) values ('адаптер');
SELECT * FROM test1.category;
#insert into test1.category (category_name) values ('моб. устройство');
#insert into test1.company (company_name) values ('ASUS');
#insert into test1.company (company_name) values ('DNS');
#insert into test1.company (company_name) values ('HP');
SELECT * FROM test1.company;
#insert into test1.status (status_name) values ('выполнено');
#insert into test1.status (status_name) values ('новая');
#insert into test1.status (status_name) values ('в процессе');
#insert into test1.status (status_name) values ('не подлежит исправлению');
SELECT * FROM test1.status;
#insert into test1.request (idcategory,short_description,warranty,idcompany,idclients,filing_date,deadline,idstatus,idstaff,description)
#values (1,'не работает охлаждение',true,1,2,'2015-11-19','2015-12-01',3,1,'При запуске дистрибутивов на основе Убунты не работает вентилятор.
#То есть потихоньку крутится, но обороты в зависимости от нагрузки на процессор или температуры не изменяет');
insert into test1.request (idcategory,short_description,warranty,idcompany,idclients,filing_date,deadline,idstatus,idstaff,description)
values (3,'экран не реагирует на прикосновения',false,2,1,'2016-04-23','2016-05-15',2,2,'Сенсорный экран перестал реагировать на прикосновения.
 Весь экран полностью. Раньше бывало, что не реагироавал в некоторый участках экрана, но я перезагружала и всё было норм.
 А теперь даже выключить не могу, так как разблокировать экран не могу.');
SELECT * FROM test1.request;