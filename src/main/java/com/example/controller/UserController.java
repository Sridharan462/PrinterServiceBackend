package com.example.controller;

import com.example.model.LoginModel;
import com.example.model.UserModel;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    public UserModel loginUser;
    @Autowired
    private UserService authService;

    public UserController() {
        super();
    }

    public UserController(UserService authService) {
        super();
        this.authService = authService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    public String addUser(@RequestBody UserModel user) {
        if (authService.findByEmail(user.getEmail()) == null) {
            if (!user.getPassword().equals(user.getConfrmpassword())) {
                return "Mismatch in password";
            }
            authService.saveUser(user);
            return "New user";
        } else
            return "user Already exist";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user/login")
    public UserModel isUserPresent(@RequestBody LoginModel login) {

        loginUser = authService.findByEmail(login.getEmail());
        if (loginUser != null) {
            if (authService.findByEmail(login.getEmail()).getUseroradmin().equals("user")) {
                if (login.getPassword().equals(authService.findByEmail(login.getEmail()).getPassword()))
                    return authService.findByEmail(login.getEmail());
//              return "incorrect password";
            } else if (authService.findByEmail(login.getEmail()).getUseroradmin().equals("admin")) {
                if (login.getPassword().equals("admin")) {
                    return authService.findByEmail(login.getEmail());
                }
//                else
//              return new Mismatch("incorrect");
            }
        }
        return null;
    }

    @GetMapping("/allUsers")
    public List<UserModel> getAllUsers() {
        return authService.findAll();
    }
}


