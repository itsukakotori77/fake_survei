package com.survei.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.survei.entities.Survei;
import com.survei.repositories.SurveiRepositories;

@Service
@Transactional
public class SurveiService {
    
    @Autowired
    private SurveiRepositories surveiRepo;

    public Survei save(Survei data){
        return surveiRepo.save(data);
    }

    public Survei findOne(Long id){
        Optional<Survei> survei = surveiRepo.findById(id);

        if(!survei.isPresent()){
            return null;
        }

        return survei.get();
    }

    public Iterable<Survei> findAll(){
        return surveiRepo.findAll();
    }

    public void removeOne(Long id){
        surveiRepo.deleteById(id);
    }
}
