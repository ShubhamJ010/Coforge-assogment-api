package com.example.ExamPortal.Repo;


import com.example.ExamPortal.Model.Address;
import com.example.ExamPortal.Model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//@ExtendWith(MockitoExtension.class)
class UserRepoTest {
//    @MockBean
//    private UserRepo userRepo;

    @Autowired
    private UserRepo userRepo;
    private Address address;
    private Address address2;

    private User user;
    private User user1;

    @BeforeEach
    public void setUp() {
        // This method will be executed before each test method
        address = Address.builder().city("Faridabad").country("India").streetNumber("nununu").build();
        address2 = Address.builder().city("Faridabad").country("India").streetNumber("nununu").build();
        user = User.builder()
                .id(10000L)
                .email("shubham@coforge.com")
                .gender("Male")
                .password("shubham")
                .confirmPassword("shubham")
                .comments("hello world")
                .firstName("Shubham")
                .lastName("Jha")
                .address(address)
                .build();

        user1 = User.builder()
                .id(19999L)
                .email("shubham1000@coforge.com")
                .gender("Male")
                .password("shubham")
                .confirmPassword("shubham")
                .comments("hello world")
                .firstName("Shubham")
                .lastName("A")
                .address(address2)
                .build();

    }


    @DisplayName("JUnit test for save user operation")
    @Test
    void save_returnSaved() {


        User user1 = userRepo.save(user);

        assertThat(user1).isNotNull();
        assertThat(user1.getId()).isGreaterThan(0);


    }

    @DisplayName("JUnit test for get employee by id operation")
    @Test
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject() {

        userRepo.save(user);

        // when -  action or the behaviour that we are going test
        User user2 = userRepo.findById(user.getId()).get();

        // then - verify the output
        assertThat(user2).isNotNull();
    }

    @DisplayName("JUnit test for find by email user operation")
    @Test
    void findByEmail_returnUser() {

        userRepo.save(user);

        assertThat(userRepo.findByEmail(user.getEmail())).isEqualTo(user);


    }

    @DisplayName("JUnit test for find all user operation")
    @Test
    void findALl_returnUsers() {

        userRepo.save(user);
        userRepo.save(user1);

        List<User> userList = userRepo.findAll();


        assertThat(userList.size()).isEqualTo(2);

    }

    @AfterEach
    void clean() {
        userRepo.deleteAll();
        user = null;
        user1 = null;
    }

}