package com.example.ExamPortal.Controller;

import com.example.ExamPortal.Model.Address;
import com.example.ExamPortal.Model.User;
import com.example.ExamPortal.Service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        Address address = user.getAddress();
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.AddUser(user, address));

    }

    @GetMapping("/all")
    public List<User> getUsers() throws Exception {
        return userService.getAllUser();
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
    public ResponseEntity<User> updateUser(@RequestBody User updatedUserData) {
        User updatedUser = userService.updateUser(updatedUserData);
        return ResponseEntity.ok(updatedUser);
    }

}
