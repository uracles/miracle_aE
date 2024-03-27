package com.api.stock_activedge.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
@Data
@Setter
@Getter
public class StockResponseDto {
    private String name;
    private BigDecimal currentPrice;
    private Timestamp createDate;
    private Timestamp lastUpdate;
}
