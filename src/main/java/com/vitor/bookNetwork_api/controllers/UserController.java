package com.vitor.bookNetwork_api.controllers;

import com.vitor.bookNetwork_api.DTOs.UserDTO;
import com.vitor.bookNetwork_api.models.User;
import com.vitor.bookNetwork_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserDTO data){

        User newUser = userService.createUser(data);
        return ResponseEntity.ok(newUser);

    }

    @GetMapping
    public List<User> list(){
        return userService.listUsers();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);

    }

}
