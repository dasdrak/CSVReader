# CSV READER AND LOADER TO MYSQL

This Java app provides a simple way to read a .csv file and persist it on MySQL

## Instructions
- 1. Create a MySQL user "springuser" with password "ThePassword" and a database called "db_test" with table called "userdata" with columns "Id, FirstName, LastName, DNI, Birthdate, Email" and set the PRIMARY KEY to "DNI" You can use the following SQL script to do so:
    ~~~
    CREATE DATABASE db_test;
    CREATE USER 'springuser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'ThePassword';
    GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON db_table TO 'springuser'@'localhost';
    CREATE TABLE userdata (Id VARCHAR(255), FirstName VARCHAR(255), LastName VARCHAR(255), DNI VARCHAR(255), Birthdate VARCHAR(255), EMAIL VARCHAR(255), PRIMARY KEY(Id));
    ~~~
    
    Then run the .jar from from the root folder on a terminal:
    ~~~
    java -jar CSVLoader.jar url="Path_where_.csv_is"
    ~~~
    If the  URL provided is not correct, you would be asked to provide one on terminal.

## Milestones

- [x] Ask for URL where the .csv is located
- [x] Input arg "URL" when launching .jar
- [x] Read .csv data
- [x] Persist data on MySQL
- [x] Check if data already exists on MySQL and avoid duplicates
- [ ] Connection with GoogleSheets (WIP)
