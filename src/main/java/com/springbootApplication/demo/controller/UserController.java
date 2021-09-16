package com.springbootApplication.demo.controller;

import com.springbootApplication.demo.entity.User;
import com.springbootApplication.demo.exception.RecordsNotFoundException;
import com.springbootApplication.demo.exception.RecordsNotSave;
import com.springbootApplication.demo.service.UserService;
import javafx.util.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Controller
@RequestMapping(value= "user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user)throws RecordsNotSave {
        userService.saveUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> getAll() throws RecordsNotFoundException {
        return userService.getAllUsers();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try{
            User user= userService.getById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateById/{id}")
    public ResponseEntity<?>update(@RequestBody User user,@PathVariable Integer id)throws RecordsNotSave{
        try {
            User existUser = userService.getById(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException exc){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("UserCount")
    public long userCount() {
        return userService.count();
    }

}
