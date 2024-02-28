package com.example.proxy.dto;

import lombok.Data;

@Data
public class BillDto {
    private String billId;
    private OrderBillDto orderBillDto;
}
