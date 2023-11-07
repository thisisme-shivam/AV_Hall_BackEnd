package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.UserException;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utility.PasswordMaker;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;
    public UserEntity validateUser(String email, String password) {

        return userRepository.findByEmailAndPassword(email,password);

    }

    public UserEntity findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity save(UserEntity user) {
        user.setPassword(PasswordMaker.generatePassword());
        userRepository.save(user);
        if(user.getId() !=null){
            mailService.sendMailToUser(user.getEmail(),user.getPassword());
        }
        return user;
    }

    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    public UserEntity findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
