package com.springboot.crude.DAO;

import com.springboot.crude.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    //Define Fields for entitymanager
    private EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) { //Automatically created by Spring Boot
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //Create a Query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        //Execute query and return the list
        return theQuery.getResultList();
    }
}
