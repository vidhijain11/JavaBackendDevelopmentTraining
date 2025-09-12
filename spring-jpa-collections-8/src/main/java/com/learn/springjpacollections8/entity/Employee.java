package com.learn.springjpacollections8.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity //maps with employee table in the database
@Table(name = "employee_info") //specifies the table name in the database
public class Employee {

    @Id //maps with primary key column of the employee table
    private int empId;
    @Column(name = "emp_name", length = 20, nullable = false) //maps with emp_name column of the employee table
    private String empName;
    private float empSal;
    private LocalDate empDoj;
    @ElementCollection(fetch = FetchType.EAGER) //to fetch the associated address objects eagerly
    @JoinTable(name = "employee_address_map", joinColumns = @JoinColumn(name = "emp_id"))
    private List<Address> address; // Embedded object

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

    public float getEmpSal() {
        return empSal;
    }

    public void setEmpSal(float empSal) {
        this.empSal = empSal;
    }

    public LocalDate getEmpDoj() {
        return empDoj;
    }

    public void setEmpDoj(LocalDate empDoj) {
        this.empDoj = empDoj;
    }

    public void setAddress(List<Address> addressList) {
        this.address = addressList;
    }
    public List<Address> getAddress() {
        return address;
    }
}
