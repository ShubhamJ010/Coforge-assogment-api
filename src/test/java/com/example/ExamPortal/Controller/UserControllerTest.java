package com.example.ExamPortal.Controller;

import com.example.ExamPortal.Helper.GenericMapper;
import com.example.ExamPortal.Model.Address;
import com.example.ExamPortal.Model.Dto.AddressDto;
import com.example.ExamPortal.Model.Dto.UserDto;
import com.example.ExamPortal.Model.User;
import com.example.ExamPortal.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

@WebMvcTest(controllers = UserController.class)
//@AutoConfigureMockMvc(addFilters = false)//remove spring security no need of token
//@ExtendWith(MockitoExtension.class)
class UserControllerTest {


    private MockMvc mockMvc;


    private ObjectMapper objectMapper;

    @Mock
    private UserService service;

    @InjectMocks
    private UserController userController;


    private AddressDto address;
    private AddressDto address2;
    private UserDto user;
    private UserDto user1;


    @BeforeEach
    public void setUp() {
        // This method will be executed before each test method
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        address = AddressDto.builder().city("Faridabad").country("India").streetNumber("nununu").build();
        address2 = AddressDto.builder().city("Faridabad").country("India").streetNumber("nununu").build();
        this.objectMapper = new ObjectMapper();
        user = UserDto.builder()
                .email("shubham@coforge.com")
                .gender("Male")
                .password("shubham")
                .comments("hello world")
                .firstName("Shubham")
                .lastName("Jha")
                .address(address)
                .build();

        user1 = UserDto.builder()
                .email("shubham1000@coforge.com")
                .gender("Male")
                .password("shubham")
                .comments("hello world")
                .firstName("Shubham")
                .lastName("A")
                .address(address2)
                .build();

    }

    @Test
    void createUser() throws Exception {

        Mockito.when(service.AddUser(Mockito.any(User.class), Mockito.any(Address.class))).thenReturn(GenericMapper.UserDtoToUserEntity(user));
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
        List<User> users = new ArrayList<>(Arrays.asList(GenericMapper.UserDtoToUserEntity(user), GenericMapper.UserDtoToUserEntity(user1)));
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
        Mockito.when(service.userById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(GenericMapper.UserDtoToUserEntity(user)));

        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", l))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id").value(l));


    }


}

