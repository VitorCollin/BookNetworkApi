package com.vitor.bookNetwork_api.DTOs;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    public UserDTO() {}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
