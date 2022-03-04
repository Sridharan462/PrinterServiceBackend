package com.example.service;

import com.example.Repository.UserRepository;
import com.example.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
