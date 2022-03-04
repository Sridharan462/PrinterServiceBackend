package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

     UserModel findByUsername(String username);
     UserModel findByEmail(String email);
     UserModel findByEmailAndPassword(String email, String password);
}