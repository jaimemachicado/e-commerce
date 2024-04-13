package com.jmachicado.inventorymanagementservice.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncrementProductDtoIn {

  private List<ProductIncrementDetailDtoIn> products;
}
