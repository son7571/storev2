package com.metacoding.storev2.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderRequest.ListDTO> 구매목록() {
        List<OrderRequest.ListDTO> orderList = orderRepository.findAll();
        return orderList;
    }
}
