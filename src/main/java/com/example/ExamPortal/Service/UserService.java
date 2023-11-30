package com.example.ExamPortal.Service;

import com.example.ExamPortal.Exception.UserExistsException;
import com.example.ExamPortal.Model.Address;
import com.example.ExamPortal.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser() throws RuntimeException;

    User AddUser(User user, Address address) throws IllegalArgumentException, UserExistsException;

    public boolean deleteUserById(Long Id) throws UserExistsException;

    User updateUser(User updatedUserData);

    Optional<User> userById(Long id) throws UserExistsException;
}
