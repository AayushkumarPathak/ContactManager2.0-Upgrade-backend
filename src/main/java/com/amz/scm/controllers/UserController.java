package com.amz.scm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amz.scm.entities.User;
import com.amz.scm.payloads.UserDto;
import com.amz.scm.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        UserDto savedUser = this.userService.saveUser(user);
        return new ResponseEntity<>(savedUser,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(){
        List<UserDto> allUsers = this.userService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String id){
        UserDto updatedUser = this.userService.updateUser(user,id);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        this.userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id){
        UserDto user = this.userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/getByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        UserDto user = this.userService.getUserByEmail(email);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/isExists/{id}")
    public ResponseEntity<?> isUserExists(@PathVariable String id){
        boolean isExists = this.userService.isUserExists(id);
        return new ResponseEntity<>(isExists,HttpStatus.OK);
    }

    



    
}
