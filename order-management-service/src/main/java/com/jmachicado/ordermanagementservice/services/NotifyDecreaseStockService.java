package com.jmachicado.ordermanagementservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotifyDecreaseStockService {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void notifyDecreaseStock(String productId) {
    kafkaTemplate.send("inventory-requests", productId);
    log.info("Decrease stock request sent for product with id: {}", productId);
  }

}
