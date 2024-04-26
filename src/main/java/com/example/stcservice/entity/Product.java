package com.example.stcservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Is mapped with a Database table - Product
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double price;
    @Column(name = "category_id")
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false) // is a column inside Product table
    private Category category;

  //  private String mobile; // country code + mobile number

//    @Transient // Use this field only in class level - This field is not mapped with the database table
//    private String countryCode;
//
//    public String getCountryCode() {
//        return mobile.substring(0,3);
//    }
}
