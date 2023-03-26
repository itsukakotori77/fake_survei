package com.survei.services;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.survei.entities.Pertanyaan;
import com.survei.repositories.PertanyaanRepositories;

@Service
@Transactional
public class PertanyaanService {
    
    @Autowired
    private PertanyaanRepositories pertanyaanRepo;

    public Pertanyaan save(Pertanyaan data){
        return pertanyaanRepo.save(data);
    }

    public Pertanyaan findOne(Long id){
        Optional<Pertanyaan> pertanyaan = pertanyaanRepo.findById(id);

        if(!pertanyaan.isPresent()){
            return null;
        }

        return pertanyaan.get();
    }

    public Iterable<Pertanyaan> findAll(){
        return pertanyaanRepo.findAll();
    }

    public void removeOne(Long id){
        pertanyaanRepo.deleteById(id);
    }
    
}
