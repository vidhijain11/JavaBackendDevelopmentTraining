package com.learn.springjpabidirectional9;

import com.learn.springjpabidirectional9.entity.Department;
import com.learn.springjpabidirectional9.entity.Employee;
import com.learn.springjpabidirectional9.repository.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJpaBidirectional9Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJpaBidirectional9Application.class, args);
        DepartmentRepository repository = context.getBean(DepartmentRepository.class);
        Department dept = new Department();
        dept.setDeptId(1);
        dept.setDeptName("IT");

        Employee emp1 = new Employee();
        emp1.setEmpId(101);
        emp1.setEmpName("John Doe");
        emp1.setEmpSal(50000);
        emp1.setDepartment(dept); // Set the department for the employee

        Employee emp2 = new Employee();
        emp2.setEmpId(102);
        emp2.setEmpName("Jane Smith");
        emp2.setEmpSal(60000);
        emp2.setDepartment(dept);

        List<Employee> employees = List.of(emp1, emp2);
        dept.setEmployees(employees);
        repository.addNewDepartment(dept); // This will also persist employees because of CascadeType.PERSIST

        Department dept2 = new Department();
        dept2.setDeptId(2);
        dept2.setDeptName("HR");
        repository.addNewDepartment(dept2); // Department with no employees

        Department dept3 = new Department();
        dept3.setDeptId(3);
        dept3.setDeptName("Finance");
        repository.addNewDepartment(dept3); // Department with no employees

        repository.getAllDepts();
        repository.searchDeptByName("IT");
        repository.searchDeptByNameUsingNamedQuery("HR");
    }

}
