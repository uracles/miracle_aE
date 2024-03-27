package com.api.stock_activedge.dto.response;

public record ApiResponse<T> (String message, int code, T data)
{}
