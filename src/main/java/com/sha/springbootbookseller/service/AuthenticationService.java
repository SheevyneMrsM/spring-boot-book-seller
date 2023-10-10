package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
//public class AuthenticationService implements IAuthenticationService {
//
//    private final  AuthenticationManager authenticationManager;
//
//
//    private final JwtService jwtService;
//@Override
//    public String signInAndReturnJWT(User signInRequest){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));
//
//        User user = (User) authentication.getPrincipal();
//        String jwt = jwtService.generateToken(user);

//    User signInUser = user.getUser();
//        signInUser.setToken(jwt);

//        return jwt;
//
//    }
//

//}
