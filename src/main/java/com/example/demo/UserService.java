package com.example.demo;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String rawPassword) {
        Optional<User> existing = userRepository.findByUsername(username);
        if (existing.isPresent()) {
            throw new RuntimeException("Użytkownik o takiej nazwie już istnieje");
        }

        String encodedPassword = passwordEncoder.encode(rawPassword);
        User user = new User(null, username, encodedPassword,
                Collections.singleton("ROLE_USER"));
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
