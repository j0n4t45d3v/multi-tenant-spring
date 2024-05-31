package com.jonatas.multitenancy.controllers;

import com.jonatas.multitenancy.model.User;
import com.jonatas.multitenancy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAll() {
        var users = this.repository.findAll();
        return ResponseEntity.ok(users);
    }
}
