package com.rest.cruddemo.service;

import com.rest.cruddemo.dao.EmployeeDAOImpl;
import com.rest.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDAOImpl employeeDAO;

    //retrives all employees
    @Transactional
    public List<Employee> getAllEmployee(){
        return employeeDAO.getAllEmployee();
    }
    //reterives employee by id
    @Transactional
    public Employee getemployeeByID(int theId)
    {
        return employeeDAO.getEmployeeById(theId);
    }
    //saves or updates new employee
    @Transactional
    public void saveEmployee(Employee theEmployee)
    {
       employeeDAO.saveEmployee(theEmployee);
    }
    //delete the employee
    @Transactional
    public void deleteEmployee(int theId)
    {
        employeeDAO.deleteEmployee(theId);
    }
}
