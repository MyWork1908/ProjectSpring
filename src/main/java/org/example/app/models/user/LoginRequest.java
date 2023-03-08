package org.example.app.models.user;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
