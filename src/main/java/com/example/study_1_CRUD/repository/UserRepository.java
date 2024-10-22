package com.example.study_1_CRUD.repository;
import com.example.study_1_CRUD.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByusername(String username);
}
