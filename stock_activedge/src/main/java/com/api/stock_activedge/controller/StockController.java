package com.api.stock_activedge.controller;

import com.api.stock_activedge.dto.response.ApiResponse;
import com.api.stock_activedge.dto.response.StockResponseDto;
import com.api.stock_activedge.dto.request.StockRequestDto;
import com.api.stock_activedge.models.Stock;
import com.api.stock_activedge.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {

  private final StockService stockService;

  @GetMapping("/all_stock")
  public ApiResponse<List<StockResponseDto>> getAllStocks() {
    return stockService.getAllStocks();
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<ApiResponse<StockResponseDto>> getStockById(@PathVariable Long id) {
    ApiResponse<StockResponseDto> stock = stockService.getStockById(id);
    return stock != null ? ResponseEntity.ok(stock) : ResponseEntity.notFound().build();
  }

  @PostMapping("/create")
  public ResponseEntity<ApiResponse<StockResponseDto>> createStock(@RequestBody StockRequestDto stock) {
    return ResponseEntity.ok(stockService.createStock(stock));
  }

  @PutMapping("/put/{id}")
  public ResponseEntity<ApiResponse<StockResponseDto>> updateStockPrice(@PathVariable Long id, @RequestBody Stock stock) {
    if (!id.equals(stock.getId())) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(stockService.updateStockPrice(id, stock.getCurrentPrice()));
  }

}
