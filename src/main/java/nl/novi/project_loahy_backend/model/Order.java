package nl.novi.project_loahy_backend.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(name="order_date")
    private LocalDate orderDate;

    @ManyToOne
    private Costumer costumer;

    @OneToMany(mappedBy="order")
    private List<Product> products;


    public Order(Costumer costumer, List<Product> products) {
        this.costumer = costumer;
        this.products = products;
    }
    public Order() {
    }


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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
    //Denk ik een one to many met producten of one to one met producten



}
