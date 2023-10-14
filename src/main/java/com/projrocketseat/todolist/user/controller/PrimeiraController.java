package com.projrocketseat.todolist.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraRota")
public class PrimeiraController {

    @GetMapping
    public String primeiraMensagem(){
        return "Hello World!";
    }

}
