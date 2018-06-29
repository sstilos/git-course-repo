package com.example.sbws2.repo;

import com.example.sbws2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> { }
