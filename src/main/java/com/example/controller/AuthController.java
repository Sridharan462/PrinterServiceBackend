package com.example.controller;

import com.example.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.service.AuthService;
import com.example.model.AuthModel;

import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    public AuthController() {
        super();
    }

    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    //@RequestMapping(value="/signup",produces = "application/json",method = RequestMethod.POST)
    @RequestMapping("/signup")
    public String addUser(@RequestBody AuthModel user) {
            if (authService.findByEmail(user.getEmail()) == null) {
                if (!user.getPassword().equals(user.getConfrmpassword())) {
                    return "Misma in password";
                }
                authService.saveUser(user);
                return "New user";
            } else
                return "user Already exist";
            //response
    }
    @CrossOrigin(origins = "http://localhost:3000")
    //@RequestMapping(value = "user/login",produces = "application/json",method = RequestMethod.POST)
    @RequestMapping("/user/login")
    public String isUserPresent(@RequestBody AuthModel login) {
        if (authService.findByEmail(login.getEmail()) != null) {
            if (authService.findByEmail(login.getEmail()).getUseroradmin().equals("user"))
                return "user";
            else
                return "admin";
        }
        return null;
    }
   // @RequestMapping(value = "/allUsers",produces = "application/json",method = RequestMethod.GET)
   @RequestMapping("/allUsers")
    public List<AuthModel> getAllUsers()
    {
        return authService.findAll();
    }


}


