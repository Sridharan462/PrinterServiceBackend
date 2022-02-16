package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.AuthModel;

@Repository
public interface AuthRepository extends JpaRepository<AuthModel,Long> {

     AuthModel findByEmail(String email);
     AuthModel findByEmailAndPassword(String email,String password);
}