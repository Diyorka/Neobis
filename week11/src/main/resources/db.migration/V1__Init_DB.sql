drop table if exists Orders;
drop table if exists Buyer;
drop table if exists Laptop;
drop table if exists Worker;
create table Buyer (id integer not null auto_increment, firstName varchar(255), lastName varchar(255), phoneNumber varchar(255), primary key (id)) engine=InnoDB;
create table Laptop (id integer not null auto_increment, manufacturer varchar(255), model varchar(255), price integer, primary key (id)) engine=InnoDB;
create table Orders (id integer not null auto_increment, orderDate varchar(255), buyerId integer, laptopId integer, primary key (id)) engine=InnoDB;
create table Worker (id integer not null auto_increment, firstName varchar(255), lastName varchar(255), phoneNumber varchar(255), position varchar(255), primary key (id)) engine=InnoDB;
alter table Orders add constraint FKhkrydoc1m3iy9q5e6djawjqaf foreign key (buyerId) references Buyer (id);
alter table Orders add constraint FKhbou76he0tur0vpnw2q34qjtu foreign key (laptopId) references Laptop (id);