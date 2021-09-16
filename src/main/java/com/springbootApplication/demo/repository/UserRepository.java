package com.springbootApplication.demo.repository;
import com.springbootApplication.demo.entity.EmployeeEntity;
import com.springbootApplication.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Integer> {
    @Async
    @Query(value = "SELECT COUNT(*) FROM employee",nativeQuery = true)
    public List<User> userCount();
}
