package com.starter.usermanagement.service;

import com.starter.usermanagement.model.User;
import com.starter.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.starter.usermanagement.dto.UserRequest;
import com.starter.usermanagement.dto.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<UserResponse> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
            .map(user -> new UserResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail()
            ));
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponse(
        user.getId(),
        user.getName(),
        user.getEmail()
    );
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());

        return userRepository.save(user);
    }

    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        User saved = userRepository.save(user);

        return new UserResponse(
            saved.getId(),
            saved.getName(),
            saved.getEmail()
        );
    }

    public UserResponse patchUser(Long id, UserRequest request) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        if (request.getName() != null) {
            user.setName(request.getName());

        }
        if (request.getEmail() != null) {
        user.setEmail(request.getEmail());

        }

        User saved = userRepository.save(user);

        return new UserResponse(
            saved.getId(),
            saved.getName(),
            saved.getEmail()
        );
    }
    public Page<UserResponse> searchUsers(String keyword, Pageable pageable) {
        return userRepository
            .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                keyword,
                keyword,
                pageable
            )
            .map(user -> new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
            ));
    }
}

