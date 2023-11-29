package com.example.ExamPortal.Impl;

import com.example.ExamPortal.Model.Address;
import com.example.ExamPortal.Model.User;
import com.example.ExamPortal.Repo.AddressRepo;
import com.example.ExamPortal.Repo.UserRepo;
import com.example.ExamPortal.Service.Impl.UserServiceImpl;
import com.example.ExamPortal.Service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {


    @Mock
    private UserRepo userRepo;
    @Mock
    private AddressRepo addressRepo;


    @InjectMocks
    private UserServiceImpl userService;

    private Address address;
    private User user;
    private User user1;


    @BeforeEach
    public void setUp() {
        // This method will be executed before each test method
        address = Address.builder().city("Faridabad").country("India").streetNumber("nununu").build();

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
                .address(address)
                .build();

    }

    @Test
    void getAllUser() {
//      List<User> userList = Mockito.mock(List.class);

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);

        Mockito.when(userRepo.findAll()).thenReturn(userList);
        Mockito.when(userRepo.count()).thenReturn(1L);

        List<User> users = userService.getAllUser();

        Assertions.assertThat(users).isNotNull().isNotEmpty();
    }

    @Test
    void UserService_addUser_ReturnUser() {

        Mockito.when(userRepo.save(Mockito.any(User.class))).thenReturn(user);
        Mockito.when(addressRepo.save(Mockito.any(Address.class))).thenReturn(address);

        User user2 = userService.AddUser(user, address);

        Assertions.assertThat(user2).isEqualTo(user);
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void findUserById_ReturnUser() {

        Mockito.when(userRepo.findById(1L)).thenReturn(Optional.ofNullable(user));

        Optional<User> user2 = userService.userById(1L);

        Assertions.assertThat(user2.get()).isNotNull();
    }
}