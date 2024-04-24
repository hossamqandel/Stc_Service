package com.example.stcservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDTO {

    private Long id;
    private int quantity;
    private String productName;
}
