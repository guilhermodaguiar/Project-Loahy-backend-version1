package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.CreateUserDto;
import nl.novi.project_loahy_backend.Dto.UserDto;
import nl.novi.project_loahy_backend.model.User;
import nl.novi.project_loahy_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        List<User> users;
        users = userService.getUsers();
        return users;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long userNumber) {

        return userService.getUser(userNumber);

    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {

        final UserDto createdUser = userService.createUser(createUserDto);

        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{userNumber}")
    public User updateUser(@PathVariable Long userNumber, @RequestBody User user) {

        return userService.updateUser(userNumber, user);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long userNumber) {

        userService.deleteUser(userNumber);

    }

}
