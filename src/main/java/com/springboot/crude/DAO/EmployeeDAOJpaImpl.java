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

    @Override
    public Employee findById(int theId) {
        //Get Employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        //Return the Employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //Save Employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        //Return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //Find Employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //Remove the Employee
        entityManager.remove(theEmployee);
    }
}
