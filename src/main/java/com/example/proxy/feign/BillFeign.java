package com.example.proxy.feign;

import com.example.proxy.dto.OrderBillDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${feignBill}", url = "${feignBillUrl}")
public interface BillFeign {
    @PostMapping("${feignBill}")
    void saveBill(@RequestBody OrderBillDto orderBillDto);
}
