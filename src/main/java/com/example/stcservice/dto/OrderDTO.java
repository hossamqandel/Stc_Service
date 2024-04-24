package com.example.stcservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class OrderDTO {

    private Long id;
    private List<OrderItemDTO> orderItems;
}
