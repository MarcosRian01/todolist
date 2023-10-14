package com.projrocketseat.todolist.user.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.projrocketseat.todolist.user.repository.UserRepository;
import com.projrocketseat.todolist.user.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody User user) {
        var userExist = userRepository.findByUsername(user.getUsername());

        if (userExist != null) {
            System.out.println("Usuario já existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário ja existe");
        }

        String encryptedPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());

        user.setPassword(encryptedPassword);

        var userCreated = userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

}
