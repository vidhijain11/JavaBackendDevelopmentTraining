package com.learn.springjpacollections8.repository;

import com.learn.springjpacollections8.entity.Address;
import com.learn.springjpacollections8.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeRepository {
    @PersistenceContext
    private EntityManager em; //responsible for managing the entity objects (CRUD operations)
    @Transactional
    public Employee addNewEmployee(Employee employee) {
       em.persist(employee); //insert query
        System.out.println("Employee added with ID: " + employee.getEmpId());
         return employee;
    }

    public void readEmployee(int empId) {
        Employee emp = em.find(Employee.class, empId); //select query. It will only load employee object not the associated address objects.
        if (emp == null) {
            System.out.println("Employee not found with ID: " + empId);
        } else {
            System.out.println("Employee Details: " + emp.getEmpId() + ", " + emp.getEmpName() + ", " + emp.getEmpSal() + ", " + emp.getEmpDoj());
            //returns proxy object of addressList
            List<Address> addressList = emp.getAddress(); //Lazy loading of address objects. It will fetch the address objects when accessed for the first time.
            //but we have used EAGER fetch type to fetch the address objects eagerly. Refer to Employee.java class
            addressList.forEach(address -> System.out.println("Address: " + address.getStreet() + ", " + address.getCity() + ", " + address.getState() + ", " + address.getZipCode()));
        }
    }
}
