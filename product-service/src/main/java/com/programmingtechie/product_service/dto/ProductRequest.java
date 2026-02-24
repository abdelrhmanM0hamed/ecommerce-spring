package com.programmingtechie.product_service.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
  //  private String category;

}
