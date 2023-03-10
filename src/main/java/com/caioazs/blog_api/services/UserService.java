package com.caioazs.blog_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioazs.blog_api.dto.UserDTO;
import com.caioazs.blog_api.exceptions.ObjectNotFoundException;
import com.caioazs.blog_api.models.User;
import com.caioazs.blog_api.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO user) {
        return new User(user.getId(), user.getName(), user.getEmail(), user.getUsername());
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
    }
}
