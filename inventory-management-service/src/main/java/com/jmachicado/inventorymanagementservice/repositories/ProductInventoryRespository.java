package com.jmachicado.inventorymanagementservice.repositories;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ProductInventoryRespository {

  private final static Map<String, Integer> productInventory = new HashMap<>();

  public ProductInventoryRespository() {
    productInventory.put("1", 10);
    productInventory.put("2", 10);
    productInventory.put("3", 10);
  }

  public void decreaseProductInventory(String productId) {
    if (!productInventory.containsKey(productId)) {
      log.error("Product with id: {} not found", productId);
      return;
    }
    Integer currentStock = productInventory.get(productId);
    productInventory.put(productId, currentStock - 1);
    log.info("Stock for product with id: {} decreased to: {}", productId,
        productInventory.get(productId));
  }

  public Integer getProductInventory(String productId) {
    if (!productInventory.containsKey(productId)) {
      log.warn("Product with id: {} not found", productId);
      return 0;
    }
    return productInventory.get(productId);
  }

  public void updateProductInventory(String productId, Integer newStock) {
    if (!productInventory.containsKey(productId)) {
      productInventory.put(productId, newStock);
    }
    productInventory.put(productId, newStock);
    log.info("Stock for product with id: {} updated to: {}", productId,
        productInventory.get(productId));
  }
}
