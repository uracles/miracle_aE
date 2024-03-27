package com.api.stock_activedge.service;

import com.api.stock_activedge.dto.response.ApiResponse;
import com.api.stock_activedge.dto.response.StockResponseDto;
import com.api.stock_activedge.dto.request.StockRequestDto;
import com.api.stock_activedge.exception.StockNotFoundException;
import com.api.stock_activedge.repository.InMemoryStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

  private final InMemoryStockRepository stockRepository;
  public ApiResponse<List<StockResponseDto>> getAllStocks() {
    List responseDto = new ArrayList<>();
    for (StockRequestDto stock : stockRepository.findAll()){
      responseDto.add(stock);
    }
    return new ApiResponse<>("Stocks retrieved successfully", 00, responseDto);
  }

  public ApiResponse<StockResponseDto> getStockById(Long id) {
    StockResponseDto responseDto = new StockResponseDto();
    BeanUtils.copyProperties(stockRepository.findById(id), responseDto);
    return new ApiResponse<>("stock id retrieved successfully", 00, responseDto);
  }

  public ApiResponse<StockResponseDto> createStock(StockRequestDto stock) {
    return new ApiResponse<>("stock is created successfully", 00, stockRepository.save(stock));
  }

  public ApiResponse<StockResponseDto> updateStockPrice(Long id, BigDecimal newPrice) {
    StockRequestDto stock = stockRepository.findById(id);
    if (stock != null) {
      stock.setCurrentPrice(newPrice);
      return new ApiResponse<>("stock price is updated successfully", 00, stockRepository.save(stock));
    } else {
      throw new StockNotFoundException("Stock not found");
    }
  }
  }
