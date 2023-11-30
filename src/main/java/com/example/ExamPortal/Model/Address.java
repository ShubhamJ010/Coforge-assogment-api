package com.example.ExamPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Address")

public class Address {
    @Id
    @SequenceGenerator(name = "user_id_sequence", initialValue = 100000, allocationSize = 2)
    @GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String city;
    private String streetNumber;
    private String country;
}