package com.api.stock_activedge.repository;

import com.api.stock_activedge.dto.response.StockResponseDto;
import com.api.stock_activedge.dto.request.StockRequestDto;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryStockRepository {

  private List<StockRequestDto> stocks = new ArrayList<>();

  public InMemoryStockRepository() {
    stocks.add(new StockRequestDto(1L, "MacBook Pro.", BigDecimal.valueOf(450550.25), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
    stocks.add(new StockRequestDto(2L, "Dell Latitude.", BigDecimal.valueOf(235700.70), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
    stocks.add(new StockRequestDto(3L, "Hp Pavilion.", BigDecimal.valueOf(33395.22), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
    stocks.add(new StockRequestDto(4L, "Acer Aspire.", BigDecimal.valueOf(214200.34), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
    stocks.add(new StockRequestDto(5L, "Toshiba Satellite", BigDecimal.valueOf(205125.90), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
  }

  public List<StockRequestDto> findAll() {
    return Collections.unmodifiableList(stocks);
  }

  public StockRequestDto findById(Long id) {
    return stocks.stream().filter(stock -> stock.getId().equals(id)).findFirst().orElse(null);
  }

  public StockResponseDto save(StockRequestDto stock) {
    if (stock.getId() == null) {
      stock.setId(getNextId());
      stock.setCreateDate(new Timestamp(System.currentTimeMillis()));
    }
    stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
    stocks.removeIf(s -> s.getId().equals(stock.getId()));
    stocks.add(stock);
    StockResponseDto responseDto = new StockResponseDto();
    BeanUtils.copyProperties(stock, responseDto);
    return responseDto;
  }

  private Long getNextId() {
    return stocks.stream().mapToLong(StockRequestDto::getId).max().orElse(0L) + 1;
  }
}
