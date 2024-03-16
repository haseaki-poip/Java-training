package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> searchAll() {
        // ユーザーTBLの内容を全検索
        return userRepository.findAll();
    }

    public List<User> searchByName(String name) {
        return userRepository.findByName(name);
    }

    public User searchById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(404, "NOT FOUND USER"));

        return user;
    }
}
