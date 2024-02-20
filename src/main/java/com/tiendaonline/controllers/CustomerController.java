package com.tiendaonline.controllers;

import com.tiendaonline.persistence.entities.CustomerEntity;
import com.tiendaonline.services.ICustomerService;
import com.tiendaonline.services.models.dtos.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/find-all")
    private ResponseEntity<List<CustomerEntity>> getallUsers(){
        return new ResponseEntity<>(customerService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getCustomerById(@PathVariable Long id){
        CustomerEntity customer = customerService.findCustomerById(id);
        if(customer==null){
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", String.format("Cliente no encontrado para el ID %d proporcionado.", id));
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
}
