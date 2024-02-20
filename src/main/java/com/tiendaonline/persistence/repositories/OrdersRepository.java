package com.tiendaonline.persistence.repositories;

import com.tiendaonline.persistence.entities.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersEntity,Long> {
}
