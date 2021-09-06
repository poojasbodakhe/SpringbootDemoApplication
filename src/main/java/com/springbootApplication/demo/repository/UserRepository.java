package com.springbootApplication.demo.repository;

import com.springbootApplication.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //@Query("SELECT * FROM user ORDER BY email DESC LIMIT 1")
    //public User findByEmail(String email);

}
