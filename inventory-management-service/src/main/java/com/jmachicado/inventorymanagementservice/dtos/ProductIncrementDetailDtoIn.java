package com.jmachicado.inventorymanagementservice.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductIncrementDetailDtoIn {

  private String productId;
  private Integer quantity;

}
