package com.jmachicado.inventorymanagementservice.services;


import com.jmachicado.inventorymanagementservice.dtos.IncrementProductDtoIn;
import com.jmachicado.inventorymanagementservice.repositories.ProductInventoryRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class IncrementStockService {

  private final ProductInventoryRespository productInventoryRepository;
  private final PublishStockUpdateService publishStockUpdateService;
  
  public void incrementStock(IncrementProductDtoIn incrementProductDtoIn) {
    incrementProductDtoIn.getProducts()
        .forEach(product -> incrementAndPublishProductStock(product.getProductId(),
            product.getQuantity()));
  }

  private void incrementAndPublishProductStock(String productId, Integer quantity) {
    incrementProductStock(productId, quantity);
    publishStockUpdateService.publishStockUpdate(productId);
  }

  private void incrementProductStock(String productId, Integer quantity) {
    Integer currentStock = productInventoryRepository.getProductInventory(productId);
    Integer newStock = currentStock + quantity;
    productInventoryRepository.updateProductInventory(productId, newStock);
  }
}
