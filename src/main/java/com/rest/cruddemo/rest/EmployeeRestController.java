package com.rest.cruddemo.rest;

import com.rest.cruddemo.dao.EmployeeDAOImpl;
import com.rest.cruddemo.entity.Employee;
import com.rest.cruddemo.errorresponse.ErrorResponseClass;
import com.rest.cruddemo.exceptions.InvalidArgument;
import com.rest.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees()
    {
         return (employeeService.getAllEmployee());
    }
    @GetMapping("/employee/{employeeId}")
    public Employee getemployeebyId(@PathVariable int employeeId)
    {
        int size=String.valueOf(employeeId).length();

        if(employeeId<0||size>4||size<4)
        {
            throw new InvalidArgument("Employee_id: "+employeeId+"is invalid!");
        }
            else
        return (employeeService.getemployeeByID(employeeId));
    }
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employees) {
        employeeService.saveEmployee(employees);
        return employees;
    }
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        employeeService.saveEmployee(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmploye(@PathVariable int employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return "deleted employee_id is :"+employeeId;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseClass> handleException(InvalidArgument exc)
    {
        ErrorResponseClass errorResponse=new ErrorResponseClass();
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimnestamp(System.currentTimeMillis());
        return (new ResponseEntity<ErrorResponseClass>(errorResponse,HttpStatus.NOT_FOUND));
    }
}
