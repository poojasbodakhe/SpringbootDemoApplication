package com.springbootApplication.demo.controller;

import com.springbootApplication.demo.entity.EmployeeEntity;
import com.springbootApplication.demo.entity.User;
import com.springbootApplication.demo.exception.RecordsNotFoundException;
import com.springbootApplication.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EmployeeController{
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody EmployeeEntity employeeEntity) {
        employeeService.saveEmployee(employeeEntity);
    }
    @GetMapping("/getAllEmployee")
    public List<EmployeeEntity> getByCompanyId()throws RecordsNotFoundException {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getByEmployeeId/{empId}")
    public ResponseEntity<EmployeeEntity> getByEmployeeId(@PathVariable Integer empId){
        try {
            EmployeeEntity employeeEntity=employeeService.getEmployeeById(empId);
            return new ResponseEntity<EmployeeEntity>(employeeEntity,HttpStatus.OK);
        }
        catch (NoSuchElementException ex){
            return new ResponseEntity<EmployeeEntity>(HttpStatus.NOT_FOUND);
        }
    }


}
