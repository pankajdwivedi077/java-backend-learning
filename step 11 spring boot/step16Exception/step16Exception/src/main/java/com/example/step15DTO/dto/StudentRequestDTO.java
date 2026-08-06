package com.example.step15DTO.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentRequestDTO {

    @NotBlank(message = "name cannot be null empty or size")
    @Size(min = 2, max = 50, message = "Student name must be within 2 to 50 charcter long")
    @NotNull(message = "Name is required")
    private String name;

    @NotBlank(message = "emial is required")
    @Email(message = "Student email must be valid")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
