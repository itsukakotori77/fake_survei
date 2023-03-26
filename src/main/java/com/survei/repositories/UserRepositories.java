package com.survei.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.survei.entities.User;

public interface UserRepositories extends JpaRepository<User, Long>{
    
    // Is user exist
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String email);

    // Get Data Exist
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String email);
}
