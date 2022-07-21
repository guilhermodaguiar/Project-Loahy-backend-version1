package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.model.User;
import nl.novi.project_loahy_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
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
    @Transactional
    public List<User> getUsers() {
        List<User> users;
        users = userService.getUsers();
        return users;
    }

    @GetMapping("/{id}")
    @Transactional
    public User getUser(@PathVariable("id") Long userId) {

        return userService.getUser(userId);

    }

    @PostMapping
    public User saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {

        return userService.updateUser(userId, user);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long userId) {

        userService.deleteUser(userId);

    }

}
