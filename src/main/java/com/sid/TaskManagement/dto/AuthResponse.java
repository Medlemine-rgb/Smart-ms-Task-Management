package com.sid.TaskManagement.dto;
import com.sid.TaskManagement.entities.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private final String token;
    private final AppUser user;
}
