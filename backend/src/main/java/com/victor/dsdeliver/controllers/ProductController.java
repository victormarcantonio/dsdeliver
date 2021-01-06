package com.victor.dsdeliver.controllers;

import com.victor.dsdeliver.dto.ProductDTO;
import com.victor.dsdeliver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
      List<ProductDTO> list = productService.findAll();
      return ResponseEntity.ok().body(list);
    }
}
