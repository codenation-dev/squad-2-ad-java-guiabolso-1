package com.squad2.CentralDeErros.service;


import com.squad2.CentralDeErros.entity.User;
import com.squad2.CentralDeErros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sun.awt.SunToolkit;

@Service
public class SecurityService {

    private UserRepository userRepository;

    @Autowired
    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserAuthenticated() {
        Authentication  authentication =  SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return userRepository.findByEmail(name);
    }
}
