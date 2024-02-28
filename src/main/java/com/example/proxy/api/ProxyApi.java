package com.example.proxy.api;

import com.example.proxy.dto.OrderBillDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ProxyApi {
    @PostMapping("${billApi}")
    void saveBill(@RequestBody OrderBillDto orderBillDto);
}
