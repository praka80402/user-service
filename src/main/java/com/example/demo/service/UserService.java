package com.example.demo.service;
import com.example.demo.customException.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> getUsersPage(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }


    //new ResourceNotFoundException("User not found with id: " + id + " and email: " + email)
    public User getUserByIdAndEmail(Long id, String email) {
        return userRepository.findByIdAndEmail(id, email)
                .orElseThrow(() ->new ResourceNotFoundException("User not found with id: " + id + " and email: " + email));
    }
    @Transactional // Yeh laga de bhai!!
    public User findUserByEmailUsingProcedure(String email) {
        return userRepository.getUserByEmail(email);
    }
}

