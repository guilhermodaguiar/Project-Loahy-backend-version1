package nl.novi.project_loahy_backend.Dto;


import java.time.LocalDate;

public class OrderDto {
    private Long OrderId;
    private LocalDate orderDate;

    private CostumerDto user;

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        this.OrderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public CostumerDto getUser() {
        return user;
    }

    public void setUser(CostumerDto user) {
        this.user = user;
    }
}
