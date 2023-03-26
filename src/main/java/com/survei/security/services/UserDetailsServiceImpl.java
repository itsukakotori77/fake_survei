package com.survei.security.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.survei.entities.User;
import com.survei.repositories.UserRepositories;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepositories userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);

        if(!user.isPresent()){
            return null;
        }

        return UserDetailsImpl.build(user.get());
    }
    
}
