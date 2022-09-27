package com.ecommerce.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> returnAllUsers(){
        List<Product> allUsers = userService.getAllUsers();

        return new ResponseEntity<>(HttpStatus.OK, allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> returnOneUser(@PathVariable Long id){
        UserModel userToReturn = userService.getOneUser(id).get();

        if(userToReturn != null){
            return new ResponseEntity<>(HttpStatus.OK, userToReturn);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND, id);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserModel> createOneUser(@RequestBody UserModel user){
        if(user != null){
            userService.createNewUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED, user);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST, user);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserModel> updateOneUser(@PathVariable Long id, @RequestBody UserModel user){
        if(user != null){
            userService.updateUser(id, user);
            return new ResponseEntity<>(HttpStatus.OK, user);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST, user);
    }

}
