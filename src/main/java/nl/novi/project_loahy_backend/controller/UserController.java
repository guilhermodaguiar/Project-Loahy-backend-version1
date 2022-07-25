package nl.novi.project_loahy_backend.controller;


import nl.novi.project_loahy_backend.Dto.CreateUserDto;
import nl.novi.project_loahy_backend.Dto.UserDto;
import nl.novi.project_loahy_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping()
    public ResponseEntity<List<UserDto>> getContacts() {

        List<UserDto> userDtos = userService.getUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(path = "/{user-id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("user-id") Long userNumber) {

        UserDto optionalUser = userService.getUser(userNumber);

        return ResponseEntity.ok().body(optionalUser);

    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {

        final UserDto createdUser = userService.createUser(createUserDto);

        final URI location = URI.create("/users/" + createdUser.getUserNumber());
        return ResponseEntity
                .created(location)
                .body(createdUser);
    }

    @PutMapping("/{userNumber}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userNumber")Long userNumber, @RequestBody UserDto userDto) {

       userService.updateUser(userNumber, userDto);

       return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<UserDto>deleteUser(@PathVariable("user-id") Long userNumber) {
        userService.deleteUser(userNumber);
        return ResponseEntity.noContent().build();
    }




}
