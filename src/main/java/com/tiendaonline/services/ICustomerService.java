package com.tiendaonline.services;

import com.tiendaonline.persistence.entities.CustomerEntity;

import java.util.List;

public interface ICustomerService {
    public List<CustomerEntity> findAllUsers();
    public CustomerEntity findCustomerById(Long id);
}
