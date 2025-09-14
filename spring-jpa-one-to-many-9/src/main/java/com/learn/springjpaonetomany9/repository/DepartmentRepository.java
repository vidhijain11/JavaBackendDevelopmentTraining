package com.learn.springjpaonetomany9.repository;

import com.learn.springjpaonetomany9.entity.Department;
import com.learn.springjpaonetomany9.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class DepartmentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Department addNewDepartment(Department dept, int empId) {
        Employee emp = entityManager.find(Employee.class, empId);
        if (emp == null) {
            throw new RuntimeException("Employee with ID " + empId + " not found");
        }
        dept.setEmployees(List.of(emp));
        entityManager.persist(dept);
        return dept;
    }

    public Employee addNewEmployee(Employee emp) {
        entityManager.persist(emp);
        return emp;
    }
}
