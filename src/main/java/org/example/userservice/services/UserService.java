package org.example.userservice.services;

import org.example.userservice.dtos.UserDto;
import org.example.userservice.models.Role;
import org.example.userservice.models.User;
import org.example.userservice.repositories.RoleRepository;
import org.example.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public UserDto getUserDetails(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return null;
        }

        return new UserDto(userOptional.get());
    }

    public UserDto setUserRoles(Long userId, List<Long> roleIds) {
        Optional<User> userOptional = userRepository.findById(userId);
        List<Role> roles = roleRepository.findAllByIdIn(roleIds);
        if (userOptional.isEmpty()) {
            return null;
        }
        User user = userOptional.get();
        user.setRoles(roles);
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser);
    }
}
