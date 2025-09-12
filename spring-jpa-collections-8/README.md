#### How can we store data when employee has two or more addresses?

We can create a separate table for addresses and use @OneToMany and @ManyToOne annotations to specify the relationship
between Employee and Address.
We will create two tables employee_info and address_info. Employee can have multiple addresses.

Using @ElementCollection to store the addresses in a separate table.
Hibernate will automatically create a separate table for addresses and map it to the employee_info table using a foreign
key.

##### How does it decide the name of the table and the foreign key column?

By default, the table name will be employee_info_address [entity class name + field name] and the foreign key column
will be employee_info_id.
We can override the default table name and foreign key column name using @JoinTable and @JoinColumn annotations.

##### find method of EntityManager

The find method of EntityManager is used to retrieve an entity from the database using its primary key

```java
Employee emp = entityManager.find(Employee.class, 1);
```

The first parameter is the entity class and the second parameter is the primary key value.
The find method returns the entity object if found, otherwise it returns null.
It will return only employee object, it will not return the addresses.
By default the collection of addresses is lazy loaded, so the addresses will be loaded only when we access the addresses
field. This improves the performance.