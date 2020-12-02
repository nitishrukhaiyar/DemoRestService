package com.rest.cruddemo.dao;

import com.rest.cruddemo.entity.Employee;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface EmployeeDAO {


    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(int theId);
    public void saveEmployee(Employee theEmployee);
    public void deleteEmployee(int theID);
}
