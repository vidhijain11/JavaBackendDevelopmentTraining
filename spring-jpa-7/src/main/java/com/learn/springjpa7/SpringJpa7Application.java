package com.learn.springjpa7;

import com.learn.springjpa7.entity.Address;
import com.learn.springjpa7.entity.Employee;
import com.learn.springjpa7.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpa7Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJpa7Application.class, args);
        EmployeeRepository repository = context.getBean(EmployeeRepository.class);
        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setEmpName("John Doe");
        emp.setEmpSal(50000);
        emp.setEmpDoj(java.time.LocalDate.of(2020, 1,
                15));
        Address add = new Address();
        add.setStreet("123 Main St");
        add.setCity("Springfield");
        add.setState("IL");
        add.setZipCode("62701");
        emp.setAddress(add);

        repository.addNewEmployee(emp);
    }

}
