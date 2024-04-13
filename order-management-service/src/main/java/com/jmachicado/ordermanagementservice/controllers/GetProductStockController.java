package com.jmachicado.ordermanagementservice.controllers;

import com.jmachicado.ordermanagementservice.services.GetProductStockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GetProductStockController {

  private final GetProductStockService getProductStockService;

  @GetMapping("/orders/products/{productId}/stock")
  @ResponseStatus(HttpStatus.OK)
  public Integer getProductStock(@PathVariable String productId) {
    log.info("Getting stock for product with id: {}", productId);
    return getProductStockService.getProductStock(productId);
  }

}
