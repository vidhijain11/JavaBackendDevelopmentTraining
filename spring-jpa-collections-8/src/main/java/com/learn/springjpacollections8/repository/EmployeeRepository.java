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
    @Transactional //required for insert, update, delete operations
    public Employee addNewEmployee(Employee employee) {
       em.persist(employee); //insert query
        System.out.println("Employee added with ID: " + employee.getEmpId());
         return employee;
    }

    public void readEmployee(int empId) {
        Employee emp = em.find(Employee.class, empId); //fires select query. It will only load employee object not the associated address objects.
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

    @Transactional
    public void readEmployeeMultipleTimesFromCache(int empId) {
        Employee emp1 = em.find(Employee.class, empId); //fires select query. It will only load employee object not the associated address objects.
        Employee emp2 = em.find(Employee.class, empId);
        if (emp1 == null) {
            System.out.println("Employee not found with ID: " + empId);
        } else {
            System.out.println("Employee Details: " + emp1.getEmpId() + ", " + emp1.getEmpName() + ", " + emp1.getEmpSal() + ", " + emp1.getEmpDoj());
            System.out.println("Employee Details: " + emp2.getEmpId() + ", " + emp2.getEmpName() + ", " + emp2.getEmpSal() + ", " + emp2.getEmpDoj());
            //returns proxy object of addressList
            List<Address> addressList = emp1 .getAddress(); //Lazy loading of address objects. It will fetch the address objects when accessed for the first time.
            //but we have used EAGER fetch type to fetch the address objects eagerly. Refer to Employee.java class
            addressList.forEach(address -> System.out.println("Address: " + address.getStreet() + ", " + address.getCity() + ", " + address.getState() + ", " + address.getZipCode()));
        }
    }
}
