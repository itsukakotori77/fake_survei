package com.survei.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.survei.entities.Responden;

public interface RespondenRepositories extends JpaRepository<Responden, Long>{
    
}
