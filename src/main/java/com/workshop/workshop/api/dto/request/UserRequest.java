package com.workshop.workshop.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "Username must not be null")
    @Size(
            max = 50,
            message = "Username cannot be longer than 50 characters."
    )
    private String username;

    @Email(message = "The email must be a valid email [example@example.com]")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters long")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$).{8,100}$",
            message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character, and no whitespace"
    )
    private String password;

    @NotBlank(message = "Full name must not be null")
    @Size(
            max = 100,
            message = "Full name cannot be longer than 100 characters."
    )
    private String fullName;

    @NotBlank(message = "Role cannot be null")
    @Pattern(regexp = "STUDENT|TEACHER|ADMINISTRATOR", message = "Role must be one of the following: STUDENT, TEACHER, ADMINISTRATOR")
    private String role;
}
