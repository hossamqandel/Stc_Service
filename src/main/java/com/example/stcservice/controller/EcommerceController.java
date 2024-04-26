package com.example.stcservice.controller;

import com.example.stcservice.dto.CategoryDTO;
import com.example.stcservice.dto.OrderDTO;
import com.example.stcservice.dto.ProductDTO;
import com.example.stcservice.entity.Product;
import com.example.stcservice.service.EcommerceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = service.getProductById(id);
        System.out.println("Category Name --> " + product.getCategory().getName());
        return ResponseEntity.ok(product);
    }

//    @GetMapping("/products/{keyword}")
//    public ResponseEntity<List<ProductDTO>> getProductsBySearch(@PathVariable String keyword) {
//        if (service.getSearchProducts(keyword).isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return ResponseEntity.ok(service.getSearchProducts(keyword));
//    }

    @PostMapping("/products") // Should be products
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {
        ProductDTO productDTO = service.addProduct(product);
        if (productDTO != null){
            // should return created http status - 201
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .build();
    }

    @GetMapping("/categories/{categoryId}/products")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Long categoryId) {
        if (service.getProductsByCategory(categoryId).isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return ResponseEntity.ok(service.getProductsByCategory(categoryId));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id){
        if (service.deleteProduct(id)) return ResponseEntity.ok(true);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/products")
    public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO){
        return ResponseEntity.ok(service.updateProduct(productDTO));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        if (service.getAllCategories().isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return ResponseEntity.ok(service.getAllCategories());
    }

    @PostMapping("/categories") // should be categories
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO category) {
        CategoryDTO categoryDTO = service.addCategory(category);
        if (categoryDTO == null) {
            return ResponseEntity
                    .status(HttpStatus.ALREADY_REPORTED)
                    .build();
        }
        // should return created http status - 201
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        if (service.getAllOrders().isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return ResponseEntity.ok(service.getAllOrders());
    }

}
