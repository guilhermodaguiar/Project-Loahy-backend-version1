package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.CreateOrderDto;
import nl.novi.project_loahy_backend.Dto.OrderDto;
import nl.novi.project_loahy_backend.service.OrderService;
import nl.novi.project_loahy_backend.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;
    private final CostumerService costumerService;

    public OrderController(OrderService orderService, CostumerService costumerService) {
        this.orderService = orderService;
        this.costumerService = costumerService;
    }

    @GetMapping()
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtos = orderService.getAllOrders();

        return ResponseEntity.ok().body(orderDtos);
    }

    @GetMapping(path = "/{order-number}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("order-number") Long orderNumber) {

        OrderDto optionalOrder = orderService.getOrderById(orderNumber);

        return ResponseEntity.ok().body(optionalOrder);
    }


    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderDto createOrderDto) {

        final OrderDto createdOrder = orderService.createOrder(createOrderDto);

        final URI location = URI.create("/orders/" + createdOrder.getOrderId());
        return ResponseEntity
                .created(location)
                .body(createdOrder);

    }

}
