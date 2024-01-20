package com.unab.registro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.registro.entitys.User;
import com.unab.registro.repository.UserRepository;

import jakarta.validation.Valid;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public void create(User user){
        if(user == null) throw new RuntimeException("Usuario Vacio");
        this.userRepository.save(user);
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }
    
    public User updateEmail(String id, String email){
      Optional<User> userExist = this.userRepository.findById(id);
      if(userExist.isPresent()){
        User actualUser = userExist.get();
        actualUser.setEmail(email);
        return this.userRepository.save(actualUser);
      }
      throw new RuntimeException("Usuario No encontrado");
    }
}
