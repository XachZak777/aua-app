package am.aua.app.controller;

import am.aua.app.dto.UserRequest;
import am.aua.app.entity.User;
import am.aua.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) {
        try {
            // Call service method to create the user
            User createdUser = userService.createUser(userRequest);
            return ResponseEntity.ok(createdUser);
        } catch (Exception ex) {
            // Log the error and return a meaningful message
            return ResponseEntity.status(400).body("Error creating user: " + ex.getMessage());
        }
    }
}