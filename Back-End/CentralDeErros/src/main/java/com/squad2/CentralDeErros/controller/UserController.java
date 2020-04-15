package com.squad2.CentralDeErros.controller;

import com.squad2.CentralDeErros.entity.User;
import com.squad2.CentralDeErros.model.UserResponse;
import com.squad2.CentralDeErros.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    //public ResponseEntity<User> addUser(@RequestBody User user){
    public @ResponseBody
    ResponseEntity<UserResponse> addUser(@RequestBody User user) throws JSONException {
        try {
            User userExists = userService.findUserByEmail(user.getEmail());
            if (userExists != null) {
                return new ResponseEntity<UserResponse>(new UserResponse(false, "User already exists.", userExists.getEmail()), HttpStatus.BAD_REQUEST);
            }

            userService.add(user);
            return new ResponseEntity<>(new UserResponse(true, "User created.", user.getEmail()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }
}