package com.jmachicado.inventorymanagementservice.services;

import com.jmachicado.inventorymanagementservice.repositories.ProductInventoryRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceiveDecreaseNotificationService {

  private final ProductInventoryRespository productInventoryRespository;
  private final PublishStockUpdateService publishStockUpdateService;

  @KafkaListener(topics = "inventory-requests", groupId = "inventory-management-service")
  public void consume(String message) {
    log.info("Consumed message: {}", message);

    String productId = message;

    productInventoryRespository.decreaseProductInventory(productId);

    publishStockUpdateService.publishStockUpdate(productId);
  }
}
