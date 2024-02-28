package com.example.proxy.service;

import com.example.proxy.dto.OrderBillDto;
import org.springframework.stereotype.Service;

@Service
public interface ProxyService {
    void saveBillService(OrderBillDto orderBillDto);
}
