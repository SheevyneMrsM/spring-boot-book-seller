package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.Role;
import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
     user.setPassword(passwordEncoder.encode(user.getPassword()));
     user.setRole(Role.USER);
     user.setCreateTime(LocalDateTime.now());

     return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }


    @Override
    @Transactional //transactional required when executing an update/delete query
    public void makeAdmin(String username){
        userRepository.updateUserRole(username, Role.ADMIN);

    }

}
