package com.zengqi.week11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class StockController {

    @Autowired
    private StockService stockService;

    @PutMapping(value = "/products/{productId}")
    public void reduceInventory(@PathVariable("productId") String productId) {
        stockService.reduceStock(productId, 1);
    }

}