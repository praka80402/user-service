package com.example.demo.service;
import com.example.demo.customException.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> getUsersPage(int page, int size) {
        // PageRequest ka use kar ke 0-based index ke saath page aur size specify karte hain
        return userRepository.findAll(PageRequest.of(page, size));
    }

    public User getUserByIdAndEmail(Long id, String email) {
        return userRepository.findByIdAndEmail(id, email)
                .orElseThrow(() ->new ResourceNotFoundException("User not found with id: " + id + " and email: " + email));
    }
}

