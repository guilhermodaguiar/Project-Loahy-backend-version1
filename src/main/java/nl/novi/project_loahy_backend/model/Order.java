package nl.novi.project_loahy_backend.model;

import nl.novi.project_loahy_backend.Dto.CostumerDto;
import nl.novi.project_loahy_backend.Dto.ProductDto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(name="order_date")
    private LocalDate orderDate;

    @ManyToOne
    private CostumerDto costumer;

    @ManyToOne
    private ProductDto product;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderNumber) {
        this.orderId = orderNumber;
    }


    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public CostumerDto getCostumer() {
        return costumer;
    }

    public void setCostumer(CostumerDto costumer) {
        this.costumer = costumer;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }


    //Denk ik een one to many met producten of one to one met producten



}
