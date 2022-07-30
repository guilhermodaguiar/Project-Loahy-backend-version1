package nl.novi.project_loahy_backend.Dto;


import nl.novi.project_loahy_backend.model.Costumer;
import nl.novi.project_loahy_backend.model.Product;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {
    public List<Product> products;
    public Long orderId;
    public LocalDate orderDate;

    public Costumer costumer;

    private Long productId;
    private String productName;
    private Long productQuantity;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductQuantity() {
    }
}
