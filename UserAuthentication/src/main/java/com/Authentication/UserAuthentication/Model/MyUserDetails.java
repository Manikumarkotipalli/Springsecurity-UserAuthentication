package com.Authentication.UserAuthentication.Model;

import com.Authentication.UserAuthentication.Model.Myuser;
import com.Authentication.UserAuthentication.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class MyUserDetails implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Myuser> user = userRepo.findByUsername(username);
        if(user.isPresent()){
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getROles(userObj))
                    .build();

                              }
        else{
            throw new UsernameNotFoundException(username);
        }

    }
    private String[] getROles(Myuser user){
        if(user.getRole() == null){
            return new String[]{"USER"};
        }
        return user.getRole().split(",");
    }
}
