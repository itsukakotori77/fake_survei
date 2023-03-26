package com.survei.services;

import org.springframework.transaction.annotation.Transactional;
import com.survei.entities.Responden;
import com.survei.repositories.RespondenRepositories;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RespondenService {
    
    @Autowired
    private RespondenRepositories respondenRepo;

    public Responden save(Responden data){
        return respondenRepo.save(data);
    }

    public Responden findOne(Long id){
        Optional<Responden> responden = respondenRepo.findById(id);

        if(!responden.isPresent()){
            return null;
        }

        return responden.get();
    }

    public Iterable<Responden> findAll(){
        return respondenRepo.findAll();
    }

    public void removeOne(Long id){
        respondenRepo.deleteById(id);
    }
    
}
