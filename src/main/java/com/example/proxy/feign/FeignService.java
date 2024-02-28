package com.example.proxy.feign;

import com.example.proxy.dto.OrderBillDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FeignService implements BillFeign {
    @Resource
    BillFeign billFeign;

    @Override
    public void saveBill(OrderBillDto orderBillDto) {
        billFeign.saveBill(orderBillDto);
    }
}
