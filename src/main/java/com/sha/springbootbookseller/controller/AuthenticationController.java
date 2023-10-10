package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")// pre-path
@RequiredArgsConstructor
public class AuthenticationController {



    private final AuthenticationService service;

//    private final IUserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthenticationResponse> signUp (
            @RequestBody  UserRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationResponse> signUp (
            @RequestBody  AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }



//    @PostMapping("/sign-up") //Api-authentication
//     public ResponseEntity<?> signUp(@RequestBody User user){
//      if (userService.findByUsername(user.getUsername()).isPresent()){
//          return  new ResponseEntity<>(HttpStatus.CONFLICT);
//      }
//      return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
//    }

//    @PostMapping("sign-in")  //api/authentication/sign-in
//    public ResponseEntity<?> signIn(@RequestBody User user){
//
//      return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
//
//    }






}
