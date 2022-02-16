package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Repository.AuthRepository;
import com.example.model.AuthModel;

import java.util.*;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authrepo;

    public AuthService(AuthRepository authrepo) {
        super();
        this.authrepo = authrepo;
    }

    public AuthService() {

    }

    public void saveUser(AuthModel user) {
        authrepo.save(user);
    }


    public List<AuthModel> findAll() {
        return authrepo.findAll();
    }


    public AuthModel findByEmail(String email) {
        return authrepo.findByEmail(email);

    }
}
