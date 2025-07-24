package com.data.session12_2.model.entity;

import com.data.session12_2.model.response.UserResponseDTO;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserResponseDTO toResponseDTO(User user) {
        Set<String> roleNames = user.getRoles().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet());

        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.isStatus(),
                roleNames
        );
    }
}