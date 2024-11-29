package am.aua.app.controller;

import am.aua.app.dto.UserRequest;
import am.aua.app.entity.User;
import am.aua.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(Integer id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser (@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok(String.format("User with %s id is not found", id));
    }

}