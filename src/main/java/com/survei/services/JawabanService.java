package com.survei.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.survei.entities.Jawaban;
import com.survei.repositories.JawabanRepositories;

@Service
@Transactional
public class JawabanService {
    
    @Autowired
    private JawabanRepositories jawabanRepo;

    public Jawaban save(Jawaban data){
        return jawabanRepo.save(data);
    }

    public Jawaban findOne(Long id){
        Optional<Jawaban> jawaban = jawabanRepo.findById(id);

        if(!jawaban.isPresent()){
            return null;
        }

        return jawaban.get();
    }

    public Iterable<Jawaban> findAll(){
        return jawabanRepo.findAll();
    }

    public void removeOne(Long id){
        jawabanRepo.deleteById(id);
    }
}
