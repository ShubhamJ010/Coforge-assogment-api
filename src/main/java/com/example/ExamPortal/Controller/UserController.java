package com.example.ExamPortal.Controller;

import com.example.ExamPortal.Helper.GenericMapper;
import com.example.ExamPortal.Model.Address;
import com.example.ExamPortal.Model.Dto.UserDto;
import com.example.ExamPortal.Model.User;
import com.example.ExamPortal.Service.Impl.UserServiceImpl;
import com.example.ExamPortal.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto) throws Exception {
        Address address = GenericMapper.AddressDtoToAddressEntity(userDto.getAddress()) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(userService
                .AddUser(GenericMapper.UserDtoToUserEntity(userDto), address));

    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) throws Exception {
        return userService.userById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Long id) throws Exception {
        return userService.deleteUserById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@Valid @RequestBody UserDto updatedUserData) {
        User updatedUser = userService.updateUser(GenericMapper.UserDtoToUserEntity(updatedUserData));
        return ResponseEntity.ok(updatedUser);
    }

}
