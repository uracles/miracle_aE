package com.api.stock_activedge.service;

import com.api.stock_activedge.dto.request.StockRequestDto;
import com.api.stock_activedge.dto.response.ApiResponse;
import com.api.stock_activedge.dto.response.StockResponseDto;
import com.api.stock_activedge.exception.StockNotFoundException;
import com.api.stock_activedge.models.Stock;
import com.api.stock_activedge.repository.InMemoryStockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
    public class StockServiceTest {

        @Mock
        private InMemoryStockRepository stockRepository;

        @InjectMocks
        private StockService stockService;

        @BeforeEach
        public void setup() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testGetAllStocks() {
            // Given
            List<StockRequestDto> stocks = new ArrayList<>();
            stocks.add(new StockRequestDto(1L, "Stock1", BigDecimal.TEN, null, null));
            stocks.add(new StockRequestDto(2L, "Stock2", BigDecimal.valueOf(20), null, null));

            when(stockRepository.findAll()).thenReturn(stocks);

            // When
            ApiResponse<List<StockResponseDto>> response = stockService.getAllStocks();

            // Then
            assertEquals("Stocks retrieved successfully", response.message());
            assertEquals(2, response.data().size());
        }

        @Test
        public void testGetStockById() {
            // Given
            StockRequestDto stock = new StockRequestDto(1L, "Stock1", BigDecimal.TEN, null, null);
            when(stockRepository.findById(1L)).thenReturn(stock);

            // When
            ApiResponse<StockResponseDto> response = stockService.getStockById(1L);

            // Then
            assertEquals("stock id retrieved successfully", response.message());
        }


        @Test
        public void testUpdateStockPrice_StockNotFound() {
            when(stockRepository.findById(1L)).thenReturn(null);

            StockNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(StockNotFoundException.class, () -> {
                stockService.updateStockPrice(1L, BigDecimal.valueOf(15));
            });
            assertEquals("Stock not found", exception.getMessage());
        }
    }
