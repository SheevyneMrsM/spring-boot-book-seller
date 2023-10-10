package com.sha.springbootbookseller.security;

import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.service.IUserService;
import com.sha.springbootbookseller.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final IUserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.findByUsername(username)
//                .orElseThrow(()-> new UsernameNotFoundException(username));
//
//        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
//        return UserDetails.builder()
//                .user(user).id(user.getId())
//                .password(user.getPassword())
//                .authorities(authorities)
//                .build();
//    }
//}
