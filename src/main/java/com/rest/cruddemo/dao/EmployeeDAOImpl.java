package com.rest.cruddemo.dao;

import com.rest.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Employee> getAllEmployee()
    {
        Session currentSession=entityManager.unwrap(Session.class);
        List<Employee> employeeList=currentSession.createQuery("from Employee").getResultList();
        return (employeeList);
    }
    @Override
    public Employee getEmployeeById(int theId) {
        Session currentSession=entityManager.unwrap(Session.class);
        Employee theEmployee=currentSession.get(Employee.class,theId);
        return theEmployee;
    }
    @Override
    public void saveEmployee(Employee theEmployee) {
        Session currentSession=entityManager.unwrap(Session.class);
        // save or update the employee
        currentSession.saveOrUpdate(theEmployee);
    }
    @Override
    public void deleteEmployee(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();
    }


}
