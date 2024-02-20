package com.tiendaonline.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product_categories")
public class ProductCategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_categories_id")
    private Long productCategoriesId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryId;

    public Long getProductCategoriesId() {
        return productCategoriesId;
    }

    public void setProductCategoriesId(Long productCategoriesId) {
        this.productCategoriesId = productCategoriesId;
    }

    public ProductEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductEntity productId) {
        this.productId = productId;
    }

    public CategoryEntity getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryEntity categoryId) {
        this.categoryId = categoryId;
    }
}
