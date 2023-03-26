package com.survei.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.survei.entities.Pertanyaan;

public interface PertanyaanRepositories extends JpaRepository<Pertanyaan, Long>{
    
    Optional<Pertanyaan> findByDeskripsi(String deskripsi);
    
}
