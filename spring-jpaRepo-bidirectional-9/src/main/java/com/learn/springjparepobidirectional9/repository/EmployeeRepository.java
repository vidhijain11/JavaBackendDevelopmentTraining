package com.learn.springjparepobidirectional9.repository;

import com.learn.springjparepobidirectional9.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
