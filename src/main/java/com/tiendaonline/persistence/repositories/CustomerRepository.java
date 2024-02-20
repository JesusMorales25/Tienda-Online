package com.tiendaonline.persistence.repositories;

import com.tiendaonline.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    @Query(value = "SELECT * FROM customer WHERE email = :email", nativeQuery = true)
    Optional<CustomerEntity> findByEmail(String email);
}
