package com.example.ExamPortal.Model.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    @NotBlank
    @Size(min = 1, max = 25)
    private String city;

    @NotBlank
    @Size(min = 1, max = 25)
    private String streetNumber;

    @NotBlank
    @Size(min = 1, max = 25)
    private String country;
}
