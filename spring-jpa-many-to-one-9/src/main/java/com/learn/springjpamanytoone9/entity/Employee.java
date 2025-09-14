package com.learn.springjpamanytoone9.entity;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    private int empId;
    private String empName;
    private double empSal;
    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
