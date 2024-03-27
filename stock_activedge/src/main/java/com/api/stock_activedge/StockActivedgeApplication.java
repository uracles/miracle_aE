package com.api.stock_activedge;

import com.api.stock_activedge.repository.InMemoryStockRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockActivedgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockActivedgeApplication.class, args);
	}

	@Bean
	public InMemoryStockRepository stockRepository() {
		return new InMemoryStockRepository();
	}

}
