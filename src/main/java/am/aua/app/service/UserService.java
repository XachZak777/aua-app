package am.aua.app.service;

import am.aua.app.dto.UserRequest;
import am.aua.app.entity.User;
import am.aua.app.exception.UserException;
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

    public User getUserById (Integer userId) {
        return userRepository.findUserByID(userId).orElseThrow(() ->
                new UserException("User not found!")
        );
    }

    public User createUser(UserRequest userRequest) {
        var savedUser = userRepository.save(
                User.builder()
                        .id(userRequest.getUserId())
                        .firstName(userRequest.getFirstName())
                        .lastName(userRequest.getLastName())
                        .email(userRequest.getEmail())
                        .status(userRequest.getStatus())
                        .isActive(userRequest.getIsActive())
                        .passkey(userRequest.getPasskey())
                        .createdAt(userRequest.getCreatedAt())
                        .build()
        );
        return savedUser;
    }
}