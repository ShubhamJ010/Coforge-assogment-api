package com.example.ExamPortal.Repo;

import com.example.ExamPortal.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
