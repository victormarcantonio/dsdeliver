package com.victor.dsdeliver.services;

import com.victor.dsdeliver.dto.OrderDTO;
import com.victor.dsdeliver.dto.ProductDTO;
import com.victor.dsdeliver.entities.Order;
import com.victor.dsdeliver.entities.Product;
import com.victor.dsdeliver.repositories.OrderRepository;
import com.victor.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = orderRepository.findOrdersWithProducts();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }
}
