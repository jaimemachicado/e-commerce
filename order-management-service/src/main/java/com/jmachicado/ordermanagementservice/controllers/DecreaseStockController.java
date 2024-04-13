package com.jmachicado.ordermanagementservice.controllers;

import com.jmachicado.ordermanagementservice.services.NotifyDecreaseStockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DecreaseStockController {

  private final NotifyDecreaseStockService notifyDecreaseStockService;

  @PatchMapping("/orders/products/{productId}/decrease-stock")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void decreaseStock(@PathVariable String productId) {
    log.info("Decreasing stock for product with id: {}", productId);
    notifyDecreaseStockService.notifyDecreaseStock(productId);
  }
}
