1. Jackson library is used in spring boot to convert java object to json and json to java object.
2. spring-boot-starter-web dependency includes jackson library by default.
3. spring-boot-starter-web dependency is used to create web applications including RESTful applications using spring
   MVC. It runs the application on an embedded tomcat server by default.
4. Types of spring container
    a. BeanFactory - It is the simplest container providing basic support for DI and defined in org.springframework.beans.factory
       package. Not suitable for java ee implementation of factory design pattern.
    b. ApplicationContext - Suitable for java ee. Superset of Bean factory. It is defined in org.springframework.context package. It provides more advanced
       features than bean factory such as event propagation, declarative mechanisms to create a bean, various ways to look up
       a bean etc.