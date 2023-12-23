package com.sid.TaskManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfile {

    private String username;
    private String email;
    private String nni;
    private String phoneNumber;
    private String address;
}
