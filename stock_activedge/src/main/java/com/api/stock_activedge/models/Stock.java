package com.api.stock_activedge.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
  private Long id;
  private String name;
  private BigDecimal currentPrice;
  private Timestamp createDate;
  private Timestamp lastUpdate;
}
