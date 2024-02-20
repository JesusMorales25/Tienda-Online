package com.tiendaonline.services.models.validation;

import com.tiendaonline.persistence.entities.CustomerEntity;
import com.tiendaonline.services.models.dtos.ResponseDTO;

public class CustomerValidations {
    public ResponseDTO validate (CustomerEntity customer){
        ResponseDTO response = new ResponseDTO();

        response.setNumOfErrors(0);

        if(customer.getFullName() == null || customer.getFullName().length()<3 || customer.getFullName().length()>50){
            response.setNumOfErrors(response.getNumOfErrors()+1);
            response.setMessage("El campo FullName no puede ser vacío / Se aceptan 3-50 caracteres");
        }

        if(customer.getCountry() == null || customer.getCountry().length()<3 || customer.getCountry().length()>15){
            response.setNumOfErrors(response.getNumOfErrors()+1);
            response.setMessage("El campo Country no puede ser vacío / Se aceptan 3-15 caracteres");
        }

        if(customer.getShippingAddress()== null || customer.getShippingAddress().length()<3 || customer.getShippingAddress().length()>50){
            response.setNumOfErrors(response.getNumOfErrors()+1);
            response.setMessage("El campo Shipping Address no puede ser vacío / Se aceptan 3-50 caracteres");
        }

        if(customer.getPhone() == null || customer.getPhone().length() != 9){
            response.setNumOfErrors(response.getNumOfErrors()+1);
            response.setMessage("El campo Phone no puede ser vacío / Se aceptan 9 caracteres");
        }


        if(customer.getEmail()==null || !customer.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            response.setNumOfErrors(response.getNumOfErrors()+1);
            response.setMessage("El campo email no es válido");
        }

        if(customer.getPassword() == null || !customer.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[a-zA-Z]).{8,16}$")){
            response.setNumOfErrors(response.getNumOfErrors()+1);
            response.setMessage("La contraseña debe tener entre 8 y 16 caracteres, al menos un número, una minúscula y una mayúscula");
        }

        return response;

    }
}
