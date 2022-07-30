package nl.novi.project_loahy_backend.service;

import nl.novi.project_loahy_backend.Dto.CostumerDto;
import nl.novi.project_loahy_backend.Dto.CreateOrderDto;
import nl.novi.project_loahy_backend.Dto.OrderDto;
import nl.novi.project_loahy_backend.Dto.ProductDto;
import nl.novi.project_loahy_backend.exeptions.OrderNotFoundException;
import nl.novi.project_loahy_backend.model.Costumer;
import nl.novi.project_loahy_backend.model.Order;
import nl.novi.project_loahy_backend.model.Product;
import nl.novi.project_loahy_backend.repository.CostumerRepository;
import nl.novi.project_loahy_backend.repository.OrderRepository;
import nl.novi.project_loahy_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CostumerRepository costumerRepository;

    private final ProductRepository productRepository;


    public OrderService(OrderRepository orderRepository, CostumerRepository costumerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.costumerRepository = costumerRepository;
        this.productRepository = productRepository;
    }

    public List<OrderDto> getAllOrders() {
        List<OrderDto> collection = new ArrayList<>();
        List<Order> list = orderRepository.findAll();
        for(Order order : list){
            collection.add(fromOrder(order));
        }
        return collection;
    }


    public OrderDto getOrderById(Long orderId) {
        new OrderDto();
        OrderDto orderDto;
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            orderDto =  fromOrder(order.get());
        } else {
            throw new OrderNotFoundException(orderId);
        }
        return orderDto;
    }


    public OrderDto createOrder (CreateOrderDto createOrderDto){
        Costumer costumer = costumerRepository
                .findById(createOrderDto.getCostumerId())
                .orElseThrow();
        List<Product> products = productRepository
                .findByProductId(createOrderDto.getProductId());


        final Order newOrder = new Order(costumer, products);
        newOrder.setOrderDate(createOrderDto.getOrderDate());
        newOrder.setCostumer(costumer);
        newOrder.setProducts(products);

        final Order savedOrder = orderRepository.save(newOrder);

        final CostumerDto costumerDto = new CostumerDto();
        costumerDto.setCostumerId(costumer.getCostumerId());
        costumerDto.setCostumerName(costumer.getCostumerName());
        costumerDto.setCostumerEmail(costumer.getCostumerEmail());
        costumerDto.setCostumerAdres(costumer.getCostumerAdres());
        costumerDto.setCostumerPhone(costumer.getCostumerPhone());

        final ProductDto productDto = new ProductDto();
        productDto.setProductId(productDto.getProductId());
        productDto.setProductName(productDto.getProductName());
        productDto.setProductQuantity(productDto.getProductQuantity());

        productDto.setProductId(productDto.getProductId());

        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(savedOrder.getOrderId());
        orderDto.setOrderDate(savedOrder.getOrderDate());
        orderDto.setCostumer(costumer);
        orderDto.setProductId(productDto.getProductId());
        orderDto.setProductName(productDto.getProductName());
        orderDto.setProductQuantity(productDto.getProductQuantity());

        return orderDto;
        }

    public void deleteOrder(Long orderId) {
        costumerRepository.deleteById(orderId);
    }


    public OrderDto fromOrder(Order order){

        OrderDto orderDto = new OrderDto();

        orderDto.setOrderId(order.getOrderId());
        orderDto.setOrderDate(order.getOrderDate());

        orderDto.setProductId(orderDto.getProductId());
        orderDto.setProductQuantity(orderDto.getProductQuantity());
        orderDto.setProductName(orderDto.getProductName());

        orderDto.orderId = order.getOrderId();
        orderDto.orderDate = order.getOrderDate();
        orderDto.costumer = order.getCostumer();
        orderDto.products = order.getProducts();


        return orderDto;
    }

}


