package com.learn.springjpacollections8;

import com.learn.springjpacollections8.entity.Address;
import com.learn.springjpacollections8.entity.Employee;
import com.learn.springjpacollections8.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaCollections8Application {
   static EmployeeRepository repository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJpaCollections8Application.class, args);
        repository = context.getBean(EmployeeRepository.class);
        addEmployee();
        readEmployee();

    }

    private static void readEmployee() {
        repository.readEmployee(101);
    }

    private static void addEmployee() {
        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setEmpName("John Doe");
        emp.setEmpSal(50000);
        emp.setEmpDoj(java.time.LocalDate.of(2020, 1,
                15));
        Address add1 = new Address();
        add1.setStreet("123 Main St");
        add1.setCity("Springfield");
        add1.setState("IL");
        add1.setZipCode("62701");

        Address add2 = new Address();
        add2.setStreet("33 Main St");
        add2.setCity("Springfield");
        add2.setState("ML");
        add2.setZipCode("1234");

        List<Address> addressList = new ArrayList<>();
        addressList.add(add1);
        addressList.add(add2);

        emp.setAddress(addressList);
        repository.addNewEmployee(emp);
    }

}
