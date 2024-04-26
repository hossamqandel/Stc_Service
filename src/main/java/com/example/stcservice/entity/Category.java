package com.example.stcservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // Category has many products 1 ---> *
//    @OneToMany(mappedBy = "category") // category is the variable name inside Product class
    @OneToMany(mappedBy = "category") // category is the variable name inside Product class
    private Set<Product> products;

    // Bi-directional mapping
    // Category 1 ---> *  1 <--- * Product

    // Unidirection
    // @OneToMany
    // @JoinColumn(name = "category_id")



}
