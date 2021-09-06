package com.springbootApplication.demo.repository;

import com.springbootApplication.demo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

    @Async
    @Query(value = "SELECT * FROM employee ORDER BY company_id DESC LIMIT 1",nativeQuery = true)
    EmployeeEntity getCompanyId(String companyId);

}
