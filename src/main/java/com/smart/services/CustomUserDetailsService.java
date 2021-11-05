package com.smart.services;

import com.smart.entities.User;
import com.smart.enums.MessageEnum;
import com.smart.exceptions.DataNotFoundException;
import com.smart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Optional<User> user= userRepository.findByEmail(email);
        if(!user.isPresent()){
            throw new UsernameNotFoundException(MessageEnum.DATA_NOT_FOUND_IN_LOAD_USER.toString());
        }
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(),user.get().getPass(),new ArrayList<>());
    }
}
