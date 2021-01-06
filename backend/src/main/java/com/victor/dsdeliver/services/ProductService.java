package com.victor.dsdeliver.services;

import com.victor.dsdeliver.dto.ProductDTO;
import com.victor.dsdeliver.entities.Product;
import com.victor.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
       List<Product> list = productRepository.findAllByOrderByNameAsc();
       return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
