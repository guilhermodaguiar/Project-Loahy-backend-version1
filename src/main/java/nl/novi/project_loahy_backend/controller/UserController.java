package nl.novi.project_loahy_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping
    public ResponseEntity<String>helloWorld(){
        return ResponseEntity.ok("Begin van de back-end");
    }
}
