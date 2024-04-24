package com.example.stcservice.controller;

import com.example.stcservice.dto.CategoryDTO;
import com.example.stcservice.dto.OrderDTO;
import com.example.stcservice.dto.ProductDTO;
import com.example.stcservice.service.EcommerceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(service.addProduct(product));
    }

    @GetMapping("/products/category/{id}")
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

    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO category) {
        return ResponseEntity.ok(service.addCategory(category));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        if (service.getAllOrders().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(service.getAllOrders());
    }
}
