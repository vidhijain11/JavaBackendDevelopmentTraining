package com.learn.springjpamanytoone9;

import com.learn.springjpamanytoone9.entity.Department;
import com.learn.springjpamanytoone9.entity.Employee;
import com.learn.springjpamanytoone9.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaManyToOne9Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJpaManyToOne9Application.class, args);
        EmployeeRepository repository = context.getBean(EmployeeRepository.class);

        Department dept = new Department();
        dept.setDeptId(1);
        dept.setDeptName("IT");
        repository.addNewDepartment(dept);

        Employee emp1 = new Employee();
        emp1.setEmpId(101);
        emp1.setEmpName("John Doe");
        emp1.setEmpSal(50000);
        repository.addNewEmployee(emp1, 1); // Associate department with employee

        Employee emp2 = new Employee();
        emp2.setEmpId(102);
        emp2.setEmpName("Jane Smith");
        emp2.setEmpSal(60000);
        repository.addNewEmployee(emp2, 1); // Associate department with employee

        Employee emp3 = new Employee();
        emp3.setEmpId(103);
        emp3.setEmpName("Alice Johnson");
        emp3.setEmpSal(55000);
        repository.addNewEmployee(emp3, 2); // will get department not found exception
    }

}
