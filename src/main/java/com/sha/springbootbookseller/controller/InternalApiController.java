package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/internal/**")
@RequiredArgsConstructor
public class InternalApiController {

    private final IUserService userService;
    @PutMapping("make-admin/{username}")
    public ResponseEntity<?> makeAdmin(@PathVariable String username){
        userService.makeAdmin(username);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
