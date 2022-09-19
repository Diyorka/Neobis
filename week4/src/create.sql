CREATE DATABASE MyShop;

USE MyShop;

CREATE TABLE Laptop(
      id int AUTO_INCREMENT PRIMARY KEY,
      manufacturer varchar(50) NOT NULL,
      model varchar(50) NOT NULL,
      price int NOT NULL
);

CREATE TABLE Buyer(
    id int AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(20) NOT NULL,
    lastName varchar(20) NOT NULL,
    phoneNumber varchar(30) NOT NULL
);

CREATE TABLE Order(
    id int AUTO_INCREMENT PRIMARY KEY,
    laptopId int,
    buyerId int,
    orderDate varchar(50) NOT NULL,
    FOREIGN KEY (laptopId) REFERENCES Laptop(id),
    FOREIGN KEY (buyerId) REFERENCES Buyer(id)
);

