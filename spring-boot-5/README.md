1. Jackson library is used in spring boot to convert java object to json and json to java object.
2. spring-boot-starter-web dependency includes jackson library by default.
3. spring-boot-starter-web dependency is used to create web applications including RESTful applications using spring
   MVC. It runs the application on an embedded tomcat server by default.
4. Types of spring container
   a. BeanFactory - It is the simplest container providing basic support for DI and defined in
   org.springframework.beans.factory
   package. Not suitable for java ee implementation of factory design pattern.
   b. ApplicationContext - Suitable for java ee. Superset of Bean factory. It is defined in org.springframework.context
   package. It provides more advanced
   features than bean factory such as event propagation, declarative mechanisms to create a bean, various ways to look
   up
   a bean etc.

REST best practices

1. Use nouns to represent resources instead of verbs. URL should represent a resource.
   Example: /products instead of /getProducts
2. Use HTTP methods to perform actions on resources.
   GET - Retrieve a resource - GET /products/101
   POST - Create a resource - POST /products
   PUT - Update a resource - PUT /products/101
   DELETE - Delete a resource - DELETE /products/101
3. Use plural nouns for resource names.
   Example: /products instead of /product

**Content - negotiation**

1. Content negotiation is the mechanism of serving different representations of a resource at the same URI, so that
   clients
   can specify which representation they prefer.
2. In spring boot, content negotiation is handled by the jakarta.xml.bind-api, jaxb-impl, jaxb-runtime dependency.
3. The client can specify the desired format using the Accept header in the HTTP request.
   Example: Accept: application/json or Accept: application/xml
    4. Spring boot supports various data formats such as JSON, XML, YAML etc. by default

       `@GetMapping(value = "/{productId}", produces = {"application/json", "application/xml"})`
       GET http://localhost:8080/products/101 supports both json and xml formats based on Accept header.

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