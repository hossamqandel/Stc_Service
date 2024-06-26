package com.example.stcservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    private Long id;
    private String name;
    private double price;
    private Long categoryId;
    private CategoryDTO category;
}

