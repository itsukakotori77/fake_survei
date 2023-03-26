package com.survei.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.survei.entities.Jawaban;

public interface JawabanRepositories extends JpaRepository<Jawaban, Long>{
    
    Optional<Jawaban> findByDeskripsi(String jawaban);
}
