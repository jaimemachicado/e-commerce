package com.jmachicado.inventorymanagementservice.controllers;


import com.jmachicado.inventorymanagementservice.dtos.IncrementProductDtoIn;
import com.jmachicado.inventorymanagementservice.services.IncrementStockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class IncrementStockController {

  private final IncrementStockService incrementStockService;

  @PatchMapping("/products/stock/increment")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void incrementStock(@RequestBody IncrementProductDtoIn incrementProductDtoIn) {
    log.info("Incrementing stock");

    incrementStockService.incrementStock(incrementProductDtoIn);

  }
}
