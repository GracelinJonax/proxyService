package com.example.proxy.service.impl;

import com.example.proxy.dto.OrderBillDto;
import com.example.proxy.feign.BillFeign;
import com.example.proxy.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class ProxyServiceImpl implements ProxyService {
    private final BillFeign billFeign;
    @Autowired
    EmailService emailService;
    @Autowired
    TemplateEngine templateEngine;


    public ProxyServiceImpl(BillFeign billFeign) {
        this.billFeign = billFeign;
    }
    @Override
    public void saveBillService(OrderBillDto orderBillDto) {
        billFeign.saveBill(orderBillDto);
        sendEmail(orderBillDto);
    }
    @Value("${productsHtml}")
    String productsHtml;
    @Value("${total}")
    String total;
    @Value("${htmlPageName}")
    String html;
    @Value("${emailSubject}")
    String subject;
    void sendEmail(OrderBillDto bill) {
        Context context=new Context();

        context.setVariable(productsHtml,bill.getProducts());
        context.setVariable(total,bill.getTotalPrice());
        String message=templateEngine.process(html,context);
        String email = bill.getUserEmail();
        emailService.sendEmail(email, subject, message);
    }
}
