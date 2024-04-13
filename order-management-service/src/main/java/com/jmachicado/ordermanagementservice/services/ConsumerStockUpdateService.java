package com.jmachicado.ordermanagementservice.services;

import com.jmachicado.ordermanagementservice.repositories.ProductStockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerStockUpdateService {

  private final ProductStockRepository productStockRepository;

  @KafkaListener(topics = "stock-updates", groupId = "order-management-service")
  public void consume(String message) {
    log.info("Consumed message: {}", message);
    String[] parts = message.split(":");
    String productId = parts[0];
    Integer quantity = Integer.parseInt(parts[1]);
    productStockRepository.updateProductStock(productId, quantity);
  }
}
