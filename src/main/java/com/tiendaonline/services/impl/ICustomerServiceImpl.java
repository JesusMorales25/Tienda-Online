package com.tiendaonline.services.impl;

import com.tiendaonline.persistence.entities.CustomerEntity;
import com.tiendaonline.persistence.repositories.CustomerRepository;
import com.tiendaonline.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ICustomerServiceImpl implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> findAllUsers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity findCustomerById(Long id){
        Optional<CustomerEntity> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }


}
