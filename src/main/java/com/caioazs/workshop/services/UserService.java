package com.caioazs.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioazs.workshop.dto.UserDTO;
import com.caioazs.workshop.exceptions.ObjectNotFoundException;
import com.caioazs.workshop.models.User;
import com.caioazs.workshop.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO user){
        return new User(user.getId(), user.getName(), user.getEmail(), user.getUsername());
    }
}
