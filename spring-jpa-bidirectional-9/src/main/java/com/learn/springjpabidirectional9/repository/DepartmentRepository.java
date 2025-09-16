package com.learn.springjpabidirectional9.repository;

import com.learn.springjpabidirectional9.entity.Department;
import com.learn.springjpabidirectional9.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class DepartmentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void addNewDepartment(Department dept) {
        entityManager.persist(dept);
    }

    public void searchEmp(int eid) {
        Employee e= entityManager.find(Employee.class, eid);
        if(e!=null) {
            System.out.println(e.getEmpId());
            System.out.println(e.getEmpName());
            Department d=e.getDepartment();
            System.out.println("working in "+d.getDeptName());
        }
    }
    //returns the list of all departments.
    public void getAllDepts() {
        String jpql="select d from Department d"; // jpql query. d is alias. Department is entity class name.
        Query q=  entityManager.createQuery(jpql);
        List<Department> depts=q.getResultList();
        depts.forEach(d->System.out.println(d.getDeptName()+" "+d.getDeptId()));
    }
    public void searchDeptByName(String dname) {
        String jpql="select d from Department d where d.deptName= :n"; //n is a placeholder for parameter
        Query q=  entityManager.createQuery(jpql);
        q.setParameter("n", dname); //setting the value of parameter n
        List<Department>depts=q.getResultList();
        depts.forEach(d->System.out.println(d.getDeptName()+" "+d.getDeptId()));
    }
    //using named query
    public void searchDeptByNameUsingNamedQuery(String dname) {
        Query q=  entityManager.createNamedQuery("searchByName");
        q.setParameter("n", dname); //setting the value of parameter n
        List<Department>depts=q.getResultList();
        depts.forEach(d->System.out.println(d.getDeptName()+" "+d.getDeptId()));
    }
}
