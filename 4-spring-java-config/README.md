#### autowiring using java-config

We don't need to use XML configuration to wire beans in Spring. We will use Java configuration.

Spring will scan the spring config class and instantiate the beans defined in it.

#### difference between spring framework and spring boot

Spring framework is a framework that provides a comprehensive programming and configuration model for modern Java-based
enterprise applications. It provides support for dependency injection, aspect-oriented programming, transaction
management, and more.
Spring Boot is a framework built on top of the Spring framework that simplifies the process of building and deploying
Spring applications. It provides a set of conventions and defaults that make it easy to create stand-alone,
production-grade Spring applications with minimal configuration.

Spring framework provides DI but needs a lot of configuration in XML, java config, annotations etc. Spring boot provides
auto configuration and starter dependencies to reduce the configuration effort.

Springboot is production ready - in default it comes with embedded tomcat server.