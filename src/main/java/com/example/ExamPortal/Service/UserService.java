package com.example.ExamPortal.Service;

import com.example.ExamPortal.Model.Address;
import com.example.ExamPortal.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser() throws Exception;
     User AddUser(User user, Address address) throws Exception;
    public boolean deleteUserById(Long userId) throws Exception;
}
