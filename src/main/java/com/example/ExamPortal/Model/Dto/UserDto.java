package com.example.ExamPortal.Model.Dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @NotBlank
    @Size(min = 3, max = 25)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 25)
    private String lastName;

    @NotBlank
    @Size(min = 5, max = 25)
    @Email
    private String email;

    private String gender;

    @NotBlank
    private String password;

    @NotBlank
    @Size(min = 1, max = 250)
    private String comments;

    @Valid
    private AddressDto address;
}
