package com.example.ExamPortal.Controller;

import com.example.ExamPortal.Model.Address;
import com.example.ExamPortal.Model.User;
import com.example.ExamPortal.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(controllers = UserController.class)
//@AutoConfigureMockMvc(addFilters = false)//remove spring security no need of token
//@ExtendWith(MockitoExtension.class)
class UserControllerTest {


    private MockMvc mockMvc;


    private ObjectMapper objectMapper;

    @Mock
    private UserService service;

    @InjectMocks
    private UserController userController;


    private Address address;
    private User user;
    private User user1;


    @BeforeEach
    public void setUp() {
        // This method will be executed before each test method
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        address = Address.builder().city("Faridabad").country("India").streetNumber("nununu").build();
        this.objectMapper = new ObjectMapper();
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
    void createUser() throws Exception {

        Mockito.when(service.AddUser(Mockito.any(User.class), Mockito.any(Address.class))).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/user/add")
                        .content(objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print()
                );


    }

    @Test
    void getUsers() throws Exception {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(user, user1));
        Mockito.when(service.getAllUser()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/user/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getUser() throws Exception {

//      Long l = Mockito.mock(Long.class);
        Long l = 10000L;
//      user.setId(2L);
        Mockito.when(service.userById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(user));

        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", l))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id").value(l));


    }


}

