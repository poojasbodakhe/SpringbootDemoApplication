package com.springbootApplication.demo.service;

import com.springbootApplication.demo.entity.EmployeeEntity;
import com.springbootApplication.demo.exception.RecordsNotFoundException;
import com.springbootApplication.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(EmployeeEntity employeeEntity)  {
        Date date = new Date();
        System.out.println("employeeEntity.getEmpId():: " + employeeEntity.getEmpId());
        employeeEntity.setCreatedDate(date);
        EmployeeEntity employeeEntity1 = employeeRepository.getCompanyId(employeeEntity.getCompanyId());

        if(employeeEntity1 == null) {
            employeeEntity.setCompanyId("ST1");
        }else {

            String compId = employeeEntity1.getCompanyId();
            String newCompId = "ST" + (Integer.parseInt(compId.substring(2, compId.length())) + 1);
            employeeEntity.setCompanyId(newCompId);
        }
        employeeRepository.save(employeeEntity);


    }
    public List<EmployeeEntity> getAllEmployee()throws RecordsNotFoundException {
        try {
            List<EmployeeEntity> EmpList= employeeRepository.findAll();
            if(EmpList.isEmpty()){
                throw new RecordsNotFoundException("Record not found");
            }
            return employeeRepository.findAll();
        }catch (Exception e) {
        System.out.println("In catch");
        throw e;
        }
    }

    public EmployeeEntity getEmployeeById(Integer empId){
        return employeeRepository.findById(empId).get();
    }


}
