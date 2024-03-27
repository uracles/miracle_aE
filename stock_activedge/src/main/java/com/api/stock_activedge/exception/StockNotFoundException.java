package com.api.stock_activedge.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class StockNotFoundException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

        public StockNotFoundException(String message){
            super(message);
        }
        public StockNotFoundException(String message, HttpStatus httpStatus) {
            this.message = message;
            this.httpStatus = httpStatus;
        }

        public StockNotFoundException(){

        }

}
