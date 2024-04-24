package com.example.stcservice.service;

import com.example.stcservice.dto.CategoryDTO;
import com.example.stcservice.dto.OrderDTO;
import com.example.stcservice.dto.ProductDTO;
import com.example.stcservice.entity.Category;
import com.example.stcservice.entity.Product;
import com.example.stcservice.repo.CategoryRepository;
import com.example.stcservice.repo.OrderRepository;
import com.example.stcservice.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EcommerceService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public ProductDTO addProduct(ProductDTO productDTO){
        Product productEntity = productRepository.save(modelMapper.map(productDTO, Product.class));
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO){
        Category categoryEntity = categoryRepository.save(modelMapper.map(categoryDTO, Category.class));
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

}