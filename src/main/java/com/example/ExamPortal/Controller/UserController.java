package com.example.ExamPortal.Controller;

import com.example.ExamPortal.Model.Address;
import com.example.ExamPortal.Model.User;
import com.example.ExamPortal.Service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserServiceImpl userService;
    @PostMapping("/add")
    public User createUser(@RequestBody User user) throws Exception {
        Address address= user.getAddress();

        return userService.AddUser(user, address);

    }
    @GetMapping("/all")
    public List<User> getUsers() throws Exception {
        return userService.getAllUser();
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable Long userId) throws Exception {
        return userService.deleteUserById(userId);
    }

}
