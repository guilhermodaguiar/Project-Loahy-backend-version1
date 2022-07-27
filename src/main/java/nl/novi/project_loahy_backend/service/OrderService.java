package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.CreateOrderDto;
import nl.novi.project_loahy_backend.Dto.OrderDto;
import nl.novi.project_loahy_backend.Dto.CostumerDto;
import nl.novi.project_loahy_backend.exeptions.OrderNotFoundException;
import nl.novi.project_loahy_backend.model.Order;
import nl.novi.project_loahy_backend.model.Costumer;
import nl.novi.project_loahy_backend.repository.OrderRepository;
import nl.novi.project_loahy_backend.repository.CostumerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CostumerRepository costumerRepository;

    public OrderService(OrderRepository orderRepository, CostumerRepository costumerRepository) {
        this.orderRepository = orderRepository;
        this.costumerRepository = costumerRepository;
    }

    public List<OrderDto> getAllOrders() {
        List<OrderDto> collection = new ArrayList<>();
        List<Order> list = orderRepository.findAll();
        for (Order order : list) {
            collection.add(fromOrder(order));
        }
        return collection;
    }
    public OrderDto getOrderById(Long orderNumber) {
        OrderDto dto = new OrderDto();
        Optional<Order> order = orderRepository.findById(orderNumber);
        if (order.isPresent()) {
            return fromOrder(order.get());
        } else {
            throw new OrderNotFoundException(orderNumber);
        }
    }


    public OrderDto createOrder (CreateOrderDto createOrderDto){
        Costumer costumer = costumerRepository
                .findById(createOrderDto.getUserNumber())
                .orElseThrow();

        final Order newOrder = new Order();
        newOrder.setOrderDate(createOrderDto.getOrderDate());
        newOrder.setUser(costumer);

        final Order savedOrder = orderRepository.save(newOrder);

        final CostumerDto costumerDto = new CostumerDto();
        costumerDto.setCostumerId(costumer.getCostumerId());
        costumerDto.setCostumerName(costumer.getCostumerName());
        costumerDto.setCostumerEmail(costumer.getCostumerEmail());
        costumerDto.setCostumerAdres(costumer.getCostumerAdres());
        costumerDto.setCostumerPhone(costumer.getCostumerPhone());

        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(savedOrder.getOrderId());
        orderDto.setOrderDate(savedOrder.getOrderDate());
        orderDto.setUser(costumerDto);

        return orderDto;
        }

}


