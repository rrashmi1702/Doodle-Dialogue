package com.example.dd.dd.Repositories;

import com.example.dd.dd.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);
    User findByEmail(String email);
    User updateUser(Long id, User user);
}
