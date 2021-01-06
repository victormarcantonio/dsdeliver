package com.victor.dsdeliver.controllers;

import com.victor.dsdeliver.dto.OrderDTO;
import com.victor.dsdeliver.dto.ProductDTO;
import com.victor.dsdeliver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto) {
      dto = orderService.insert(dto);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                 .buildAndExpand(dto.getId()).toUri();
      return ResponseEntity.created(uri).body(dto);
    }


}
