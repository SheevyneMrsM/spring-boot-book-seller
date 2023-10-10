package com.sha.springbootbookseller.service;


import com.sha.springbootbookseller.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IAuthenticationService {
    String signInAndReturnJWT(User signInRequest);
}
