##### autowiring using annotation

Removing xml configuration and replacing bean with component annotation.
`<ctx:component-scan base-package="com.geek"></ctx:component-scan>`

we have many classes in our project and we want to create bean for all the classes.
we can use component scan to create bean for all the classes in the specified package.
we can use @Component annotation to create bean for a class.

It will scan all the classes in the specified package and create bean for all the classes which are annotated with @Component annotation.
Whichever method is annotated with @Autowired annotation, spring will look for the bean of that type and will inject it.

@Autowired can be used on:
1. Constructor
2. Setter method
3. Field -
    `@Autowired
    private AccountRepository accountRepository;`
    How field injection is done for private field?
       Spring created the setter method for field injection at run time. 
       Spring uses reflection to set the value of the private field.


##### ambiguity in autowiring
If there are multiple beans of the same type, spring will throw an exception.
    for example, if we have two beans of type AccountRepository, spring will not know which bean to inject.
    CreditCardAccountImpl and SavingsAccountImpl both implements AccountRepository interface. They both implement the same method -"creditFunds".
    
    If we try to autowire AccountRepository in AccountServiceImpl, spring will throw an exception because it doesn't know which bean to inject.


To resolve this ambiguity, we can use @Qualifier annotation to specify the bean name.
`@Qualifier("serviceAccountImpl")`

We can use @Primary annotation to specify the primary bean.
`@Primary`
If there are multiple beans of the same type and one of them is annotated with @Primary, spring will inject the primary bean.