**JDBC connectivity in spring boot**

1. JDBC - Java Database Connectivity is an API that enables java applications to interact with a database.
   JDBC driver interacts with different DB's like Oracle, MySQL, Postgres etc.

2. Every DB vendors provide drivers. This driver implement the JDBC api. Drivers provide the implementation of abstract
   methods. It's a pure JAVA code.

Steps involved in JDBC connectivity
1) Load and register the JDBC driver
2) Establish the connection
3) Create a statement
4) Execute the query
5) Process the result set
6) Close the connection

executeQuery loads all the records and returns the result set. The result set is a pointer to the records. We can iterate
through the records using next() method.

executeUpdate is used to execute DML statements like insert, update, delete. It returns the number of rows affected.

**Note:-** In this project I am using sqlite DB. It's a file based DB. No need to install any DB server.
Steps to use sqlite DB in mac. Run following commands in terminal
````

sqlite3 my_database.db

sqlite> .tables

sqlite> select * from product;

sqlite> select * from product where price between 0 and 1000;
````