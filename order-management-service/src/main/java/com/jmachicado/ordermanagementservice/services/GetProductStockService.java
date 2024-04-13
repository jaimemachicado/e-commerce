package com.jmachicado.ordermanagementservice.services;

import com.jmachicado.ordermanagementservice.repositories.ProductStockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetProductStockService {

  private final ProductStockRepository productStockRepository;

  public Integer getProductStock(String productId) {
    log.info("Getting stock for product with id: {}", productId);
    return productStockRepository.getProductStock(productId);
  }

}
