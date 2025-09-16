package com.learn.springjparepobidirectional9;

import com.learn.springjparepobidirectional9.entity.Department;
import com.learn.springjparepobidirectional9.repository.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJpaRepoBidirectional9Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJpaRepoBidirectional9Application.class, args);
        DepartmentRepository repository = context.getBean(DepartmentRepository.class);

        Department dept1 = new Department();
        dept1.setDeptId(1);
        dept1.setDeptName("IT");
        repository.save(dept1);

        Department dept2 = new Department();
        dept2.setDeptId(2);
        dept2.setDeptName("HR");
        repository.save(dept2); // Department with no employees

        Department dept3 = new Department();
        dept3.setDeptId(3);
        dept3.setDeptName("Finance");
        repository.save(dept3); // Department with no employees

        List<Department> depts=repository.findAll();
        depts.forEach(d->System.out.println(d.getDeptId()+" "+d.getDeptName()));

        List<Department> deptsFiltered = repository.findByDeptName("Finance");
        deptsFiltered.forEach(d->System.out.println(d.getDeptId()+" "+d.getDeptName()));

        repository.findById(2).ifPresent(d-> System.out.println(d.getDeptId()+" "+d.getDeptName()));
    }

}
