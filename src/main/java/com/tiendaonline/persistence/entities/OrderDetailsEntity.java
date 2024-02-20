package com.tiendaonline.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private Long orderDetailsId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrdersEntity orderId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;

    @Column(columnDefinition = "Decimal(5,2)")
    private Double price;

    private String sku;
    private Integer quantity;

    public Long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public OrdersEntity getOrderId() {
        return orderId;
    }

    public void setOrderId(OrdersEntity orderId) {
        this.orderId = orderId;
    }

    public ProductEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductEntity productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
