package com.survei.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.survei.entities.User;
import com.survei.repositories.UserRepositories;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepositories userRepo;

    public User save(User data){
        return userRepo.save(data);
    }

    public User findOne(Long id){
        Optional<User> user = userRepo.findById(id);

        if(!user.isPresent()){
            return null;
        }

        return user.get();
    }

    public Iterable<User> findAll(){
        return userRepo.findAll();
    }

    public void removeOne(Long id){
        userRepo.deleteById(id);
    }
}
