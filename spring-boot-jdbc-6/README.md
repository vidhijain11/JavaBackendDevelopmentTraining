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