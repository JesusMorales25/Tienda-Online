package com.tiendaonline.persistence.repositories;

import com.tiendaonline.persistence.entities.ProductCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoriesRepository extends JpaRepository<ProductCategoriesEntity, Long> {
}
