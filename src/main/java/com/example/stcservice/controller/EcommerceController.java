package com.example.stcservice.controller;

import com.example.stcservice.dto.CategoryDTO;
import com.example.stcservice.dto.OrderDTO;
import com.example.stcservice.dto.ProductDTO;
import com.example.stcservice.service.EcommerceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController // Tell spring this is a rest controller so it can handle some nessasry work
@RequestMapping("/api/v1") // You may need to add api version
@AllArgsConstructor
public class EcommerceController {

    private final EcommerceService service;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        if (service.getAllProducts().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(service.getAllProducts());
    }

    @PostMapping("/product") // Should be products
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(service.addProduct(product)); // should return created http status - 201
    }

    @GetMapping("/categories/{categoryId}/products")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Long id) {
        if (service.getProductsByCategory(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(service.getProductsByCategory(id));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        if (service.getAllCategories().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(service.getAllCategories());
    }

    @PostMapping("/category") // should be categories
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO category) {
        return ResponseEntity.ok(service.addCategory(category)); // should return created http status - 201
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        if (service.getAllOrders().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(service.getAllOrders());
    }
}
