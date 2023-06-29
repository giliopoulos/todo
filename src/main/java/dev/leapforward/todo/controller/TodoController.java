package dev.leapforward.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("todo")
    public ResponseEntity<String> getAll(){
        return ResponseEntity.ok("ok");
    }
}
