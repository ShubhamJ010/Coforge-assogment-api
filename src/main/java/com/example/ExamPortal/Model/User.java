package com.example.ExamPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "user_id_sequence", initialValue = 100000, allocationSize = 2)
    @GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String confirmPassword;
    private String gender;
    private String comments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


}
