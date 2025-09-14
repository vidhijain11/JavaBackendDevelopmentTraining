package com.learn.springjpamanytoone9.repository;

import com.learn.springjpamanytoone9.entity.Department;
import com.learn.springjpamanytoone9.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class EmployeeRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void addNewEmployee(Employee emp, int deptId) {
        Department dept = entityManager.find(Department.class, deptId);
        if (dept == null) {
            throw new RuntimeException("Department with ID " + deptId + " not found");
        }
        emp.setDepartment(dept);
        entityManager.persist(emp);
    }

    public void addNewDepartment(Department dept) {
        entityManager.persist(dept);
    }
}
