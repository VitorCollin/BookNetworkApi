package com.vitor.bookNetwork_api.services;

import com.vitor.bookNetwork_api.DTOs.UserDTO;
import com.vitor.bookNetwork_api.models.User;
import com.vitor.bookNetwork_api.repositories.UserRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public User createUser(UserDTO data){

        User user = modelMapper.map(data, User.class);
        return userRepository.save(user);

    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public User listUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User whit ID not found"));
    }

    public User updateUser (Long id, UserDTO data){

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User whit ID not found"));

        modelMapper.map(data, user);

        return userRepository.save(user);
    }

    public void deleteUser(Long id){

        if(!userRepository.existsById(id)){
            throw new RuntimeException("User Not Found");
        }
        userRepository.deleteById(id);
    }


}
