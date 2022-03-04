package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.UserRepository;
import com.example.model.UserModel;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository authrepo;

    public UserService(UserRepository authrepo) {
        super();
        this.authrepo = authrepo;
    }

    public UserService() {

    }

    public void saveUser(UserModel user) {
        authrepo.save(user);
    }


    public List<UserModel> findAll() {
        return authrepo.findAll();
    }


    public UserModel findByEmail(String email) {
        return authrepo.findByEmail(email);

    }
}
