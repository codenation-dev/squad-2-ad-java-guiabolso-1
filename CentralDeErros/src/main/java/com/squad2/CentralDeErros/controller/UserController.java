package com.squad2.CentralDeErros.controller;

import com.squad2.CentralDeErros.entity.Log;
import com.squad2.CentralDeErros.entity.User;
import com.squad2.CentralDeErros.entity.enumerate.Environment;
import com.squad2.CentralDeErros.entity.enumerate.Status;
import com.squad2.CentralDeErros.service.LogService;
import com.squad2.CentralDeErros.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    //public ResponseEntity<User> addUser(@RequestBody User user){
    public  @ResponseBody ResponseEntity<JSONObject> addUser(@RequestBody User user) throws JSONException {
       /* try {
          return new ResponseEntity<>(userService.add(user),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        */
        JSONObject responseJson = new JSONObject();

        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            responseJson.put("status", "User already exists.");

            return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);

        }

        userService.add (user);

        responseJson.put("status", "User created.");
        responseJson.put("user", user.getEmail());

        return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);

    }
}