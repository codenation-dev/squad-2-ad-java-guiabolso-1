package com.squad2.CentralDeErros.service;


import com.squad2.CentralDeErros.entity.User;
import com.squad2.CentralDeErros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User add(Object object) {
        return userRepository.save((User)object);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
