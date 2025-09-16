package com.learn.springjparepobidirectional9.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    private int deptId;
    private String deptName;
    // mappedBy should be the name of the field in Employee class which is holding the reference of Department class
    @OneToMany(mappedBy="department", cascade = CascadeType.PERSIST)
    private List<Employee> employees; //inverse side. mappedBy should be used only on the inverse side.

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
