package com.rodrigocbarj.hrpayroll.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rodrigocbarj.hrpayroll.entities.Payment;
import com.rodrigocbarj.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{workedDays}")
    public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable Integer workedDays) {
        Payment payment = service.getPayment(workerId, workedDays);
        return ResponseEntity.ok(payment);
    }
    public ResponseEntity<Payment> getPaymentAlternative(long workerId, Integer workedDays) {
        Payment payment = new Payment("Elon", 400.0, workedDays);
        return ResponseEntity.ok(payment);
    }
}
