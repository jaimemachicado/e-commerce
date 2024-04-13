package com.jmachicado.inventorymanagementservice.services;

import com.jmachicado.inventorymanagementservice.repositories.ProductInventoryRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublishStockUpdateService {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final ProductInventoryRespository productInventoryRespository;

  public void publishStockUpdate(String productId) {
    Integer quantity = productInventoryRespository.getProductInventory(productId);
    kafkaTemplate.send("stock-updates", productId.concat(":").concat(String.valueOf(quantity)));
    log.info("Stock update published for product with id: {} and quantity: {}", productId,
        quantity);
  }
}
