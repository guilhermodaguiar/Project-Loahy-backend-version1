package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.CreateOrderDto;
import nl.novi.project_loahy_backend.Dto.OrderDto;
import nl.novi.project_loahy_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createUser(@RequestBody CreateOrderDto createOrderDto) {

        final OrderDto createdOrder = orderService.createOrder(createOrderDto);

        final URI location = URI.create("/orders/" + createdOrder.getOrderNumber());
        return ResponseEntity
                .created(location)
                .body(createdOrder);
    }

}
