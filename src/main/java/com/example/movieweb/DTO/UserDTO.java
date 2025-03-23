package com.example.movieweb.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @JsonProperty("facebook_account_id")
    private int facebookAccountId;
    @JsonProperty("google_account_id")
    private int googleAccountId;
}
