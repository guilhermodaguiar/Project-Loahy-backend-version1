package nl.novi.project_loahy_backend.Dto;

import java.time.LocalDate;

public class CreateOrderDto {
    private LocalDate orderDate;
    private Long userNumber;

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }
}
