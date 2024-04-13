package com.jmachicado.ordermanagementservice.repositories;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ProductStockRepository {

  private static final Map<String, Integer> productStock = new HashMap<>();

  public ProductStockRepository() {
    productStock.put("1", 10);
    productStock.put("2", 10);
    productStock.put("3", 10);
  }

  public Integer getProductStock(String productId) {
    if (!productStock.containsKey(productId)) {
      log.warn("Product with id: {} not found", productId);
      return 0;
    }
    return productStock.get(productId);
  }

  public void updateProductStock(String productId, Integer quantity) {
    if (!productStock.containsKey(productId)) {
      productStock.put(productId, quantity);
    }
    productStock.put(productId, quantity);
    log.info("Stock for product with id: {} updated to: {}", productId,
        productStock.get(productId));
  }
}
