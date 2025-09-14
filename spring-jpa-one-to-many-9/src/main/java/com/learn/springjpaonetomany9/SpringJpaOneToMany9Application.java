package com.learn.springjpaonetomany9;

import com.learn.springjpaonetomany9.entity.Department;
import com.learn.springjpaonetomany9.entity.Employee;
import com.learn.springjpaonetomany9.repository.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaOneToMany9Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJpaOneToMany9Application.class, args);
        // Get the repository bean from the context
        DepartmentRepository repository = context.getBean(DepartmentRepository.class);

        Employee emp1 = new Employee();
        emp1.setEmpId(101);
        emp1.setEmpName("John Doe");
        emp1.setEmpSal(50000);
        repository.addNewEmployee(emp1);

        Employee emp2 = new Employee();
        emp2.setEmpId(102);
        emp2.setEmpName("Jane Smith");
        emp2.setEmpSal(60000);
        repository.addNewEmployee(emp2);

        Department dept = new Department();
        dept.setDeptId(1);
        dept.setDeptName("IT");
        repository.addNewDepartment(dept, 102); // Associate department with employee ID 102
    }

}
