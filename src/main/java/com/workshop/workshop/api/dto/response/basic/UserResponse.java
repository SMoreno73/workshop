package com.workshop.workshop.api.dto.response.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;

    private String username;

    private String email;

    private String password;

    private String fullName;

    private String role;
}
