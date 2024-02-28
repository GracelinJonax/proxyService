package com.example.proxy.controller;

import com.example.proxy.dto.OrderBillDto;
import com.example.proxy.service.ProxyService;
import com.example.proxy.api.ProxyApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController implements ProxyApi {
    private final ProxyService proxyService;

    public ProxyController(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @Override
    public void saveBill(OrderBillDto orderBillDto) {
        proxyService.saveBillService(orderBillDto);
    }
}
