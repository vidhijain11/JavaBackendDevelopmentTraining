package com.learn.springjparepobidirectional9.repository;

import com.learn.springjparepobidirectional9.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    //query method name - findBy + field name. Here field name is deptName which is defined in Department entity class.
    // So method name is findByDeptName.
    List<Department> findByDeptName(String name);
}
