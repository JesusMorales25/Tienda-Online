package com.tiendaonline.persistence.repositories;

import com.tiendaonline.persistence.entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {
}
