package am.aua.app.service;

import am.aua.app.dto.UserRequest;
import am.aua.app.entity.User;
import am.aua.app.exception.UserNotFoundException;
import am.aua.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllUsers () {
        return userRepository.findAll();
    }

    public User findUserById (Integer userId) {
        return userRepository.findUserById(userId).orElseThrow(() ->
                new UserNotFoundException("User not found!")
        );
    }

    public User getUserById (Integer userId) {
        return userRepository.findUserById(userId).orElseThrow(() ->
                new UserNotFoundException("User not found!")
        );
    }

    public User createUser(UserRequest userRequest) {
        var savedUser = userRepository.save(
                User.builder()
                        .firstName(userRequest.getFirstName())
                        .lastName(userRequest.getLastName())
                        .email(userRequest.getEmail())
                        .passkey(userRequest.getPasskey())
                        .createdAt(userRequest.getCreatedAt())
                        .status(userRequest.getStatus())
                        .isActive(userRequest.getIsActive())
                        .build()
        );
        return savedUser;
    }

    public void deleteUserById (Integer id) {
        User user = userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException("User not found!"));
        userRepository.deleteById(id);
    }
}