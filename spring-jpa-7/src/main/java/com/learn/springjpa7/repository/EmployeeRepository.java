package com.learn.springjpa7.repository;

import com.learn.springjpa7.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {
    @PersistenceContext
    private EntityManager em; //responsible for managing the entity objects (CRUD operations)
    @Transactional
    public Employee addNewEmployee(Employee employee) {
       em.persist(employee); //insert query
         return employee;
    }
}
