package com.tiendaonline.controllers;

import com.tiendaonline.persistence.entities.CustomerEntity;
import com.tiendaonline.services.IAuthService;
import com.tiendaonline.services.models.dtos.LoginDTO;
import com.tiendaonline.services.models.dtos.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    IAuthService authService;

    @PostMapping("/register")
    private ResponseEntity<ResponseDTO> register(@RequestBody CustomerEntity customer) throws Exception {
        return new ResponseEntity<>(authService.register(customer), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    private ResponseEntity<HashMap<String, String>> login(@RequestBody LoginDTO loginRequest) throws Exception {
        HashMap<String,String> login = authService.login(loginRequest);
        if(login.containsKey("jwt")){
            return new ResponseEntity<>(login,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
        }
    }


}
