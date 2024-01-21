package com.unab.registro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.registro.entitys.User;
import com.unab.registro.repository.UserRepository;


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
    
    public User updateUser(String id, User user){
      Optional<User> userExist = this.userRepository.findById(id);
      if(userExist.isPresent()){
        User actualUser = user;
        actualUser.setId(userExist.get().getId());
        return this.userRepository.save(actualUser);
      }
      throw new RuntimeException("Usuario No encontrado");
    }

    public void deleteUser(String id ){
      Optional<User> userExist = this.userRepository.findById(id);
      if(userExist.isPresent()){
        this.userRepository.delete(userExist.get());
      
      }
      else{
        throw new RuntimeException("Usuario No Encontrado");
      }
    }
    public User fetchByEmail(String email){
        return this.userRepository.findByEmail(email);
    }
}
