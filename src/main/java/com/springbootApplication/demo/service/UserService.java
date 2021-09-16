package com.springbootApplication.demo.service;

import com.springbootApplication.demo.entity.User;
import com.springbootApplication.demo.exception.RecordsNotFoundException;
import com.springbootApplication.demo.exception.RecordsNotSave;
import com.springbootApplication.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;



     public void  saveUser (User user)throws RecordsNotSave {
            try {
                System.out.println("In Try");

                Date date = new Date();
                System.out.println("DATE:: " + date);
                user.setCreatedDate(date);
                user.setCollegeName("DY Patil");

                repo.save(user);

            } catch (Exception exc) {
                System.out.println("In Catch");
                throw new RecordsNotSave("Records not Save...!!!");
            }

        }

        public List<User> getAllUsers()throws RecordsNotFoundException{
            try {
                List<User> userList = repo.findAll();
                if(userList.isEmpty()){
                    throw new RecordsNotFoundException("Record not found");
                }
                return repo.findAll();
            }catch (Exception e) {
                System.out.println("In catch");
                throw e;
            }
        }

        public User getById (Integer id){
        return repo.findById(id).get(); }

        public long count(){
         return  repo.count();
        }




}
