package com.tiendaonline.services.impl;

import com.tiendaonline.persistence.entities.CustomerEntity;
import com.tiendaonline.services.models.dtos.LoginDTO;
import com.tiendaonline.services.models.dtos.ResponseDTO;
import com.tiendaonline.persistence.repositories.CustomerRepository;
import com.tiendaonline.services.IAuthService;
import com.tiendaonline.services.IJWTUtilityService;
import com.tiendaonline.services.models.validation.CustomerValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IJWTUtilityService jwtUtilityService;

    @Autowired
    private CustomerValidations customerValidations;

    @Override
    public HashMap<String,String> login(LoginDTO login) throws Exception {
        try {
            HashMap<String,String> jwt = new HashMap<>();
            Optional<CustomerEntity> customer = customerRepository.findByEmail(login.getEmail());

            if(customer.isEmpty()){
                jwt.put("error","Customer not registred!");
                return jwt;
            }

            if(verifiPassword(login.getPassword(), customer.get().getPassword())){
                jwt.put("jwt", jwtUtilityService.generateJWT(customer.get().getCustomerId()));
            }else{
                jwt.put("error","Authentication failed");
            }
            return jwt;
        }catch (Exception e){
            throw new Exception(e.toString());
        }
    }

    public ResponseDTO register(CustomerEntity customer) throws Exception{
        try {
            ResponseDTO response = customerValidations.validate(customer);
            if(response.getNumOfErrors()>0){
                return response;
            }
            List<CustomerEntity> getAllCustomers = customerRepository.findAll();

            for (CustomerEntity repeatFields : getAllCustomers){
                if (repeatFields.getEmail().equals(customer.getEmail())) {
                    response.setMessage("Email already exists!");
                    return response;
                }
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            customer.setPassword(encoder.encode(customer.getPassword()));
            customerRepository.save(customer);
            response.setMessage("Customer created Succesfully!");

            return response;
        }catch (Exception e){
            throw new Exception(e.toString());
        }

    }


    private boolean verifiPassword(String enteredPassword, String storePassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword,storePassword);
    }
}
