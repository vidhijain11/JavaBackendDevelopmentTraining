Connecting the beans is called wiring. Wiring is the process of configuring how beans are created, how they interact
with each other, and how they are managed within the Spring container. This can be done in several ways:

1. XML Configuration: In the early versions of Spring, XML configuration files were commonly used to define beans and
   their dependencies. You would create an XML file (e.g., applicationContext.xml) where you specify bean definitions
   and their relationships.

#### autowire the beans using XML - using reference keyword

   ` <bean id="controller" class="com.geek.controller.AccountController">
   <property name="accountService" ref="service"></property>
   </bean>
   <bean id="service" class="com.geek.service.AccountServiceImpl">
   <property name="accountRepository" ref="repo"></property>
   </bean>
   <bean id="repo" class="com.geek.repository.AccountRepositoryImpl">
   </bean>`


#### autowire the beans using XML - using autowire keyword

`   <bean id="controller" class="com.geek.controller.AccountController" autowire="byType">
   </bean>
   <bean id="service" class="com.geek.service.AccountServiceImpl" autowire="byType">
   </bean>
   <bean id="repo" class="com.geek.repository.AccountRepositoryImpl" autowire="byType">
   </bean>`


2. Java-based Configuration: With the introduction of Java-based configuration, you can use annotations and Java classes
   to define beans and their dependencies. This approach is more type-safe and allows for better refactoring support.
   You can use the @Configuration annotation on a class and the @Bean annotation on methods to define beans.
3. Component Scanning: Spring can automatically detect and register beans by scanning the classpath for classes
   annotated with @Component, @Service, @Repository, or @Controller. This approach reduces the need for explicit bean
   definitions.
4. Autowiring: Spring provides several autowiring modes (e.g., byType, byName, constructor) that allow you to
   automatically inject dependencies into beans without explicitly defining them in the configuration. You can use the
   @Autowired annotation to indicate that a dependency should be injected.
5. Profiles: Spring supports the concept of profiles, which allows you to define different configurations for different
   environments (e.g., development, testing, production). You can use the @Profile annotation to specify which beans
   should be active in a particular profile.
6. Property Sources: You can externalize configuration properties using property files, YAML files, or environment
   variables. Spring provides the @Value annotation to inject property values into beans.