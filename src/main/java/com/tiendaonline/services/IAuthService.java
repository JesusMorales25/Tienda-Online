package com.tiendaonline.services;

import com.tiendaonline.persistence.entities.CustomerEntity;
import com.tiendaonline.services.models.dtos.LoginDTO;
import com.tiendaonline.services.models.dtos.ResponseDTO;

import java.util.HashMap;

public interface IAuthService {
    public HashMap<String,String> login(LoginDTO login) throws Exception;

    public ResponseDTO register(CustomerEntity customer) throws Exception;
}
