package com.sid.TaskManagement.dto;
import com.sid.TaskManagement.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private final String token;
    private final User user;
}
