package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.Dto.CreateOrderDto;
import nl.novi.project_loahy_backend.Dto.OrderDto;
import nl.novi.project_loahy_backend.service.OrderService;
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

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping()
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtos = orderService.getAllOrders();

        return ResponseEntity.ok().body(orderDtos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Long orderId) {

        OrderDto optionalOrder = orderService.getOrderById(orderId);

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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<OrderDto> deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

}
