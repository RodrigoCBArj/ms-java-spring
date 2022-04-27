package com.rodrigocbarj.hrpayroll.services;

import com.rodrigocbarj.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int workedDays) {
        return new Payment("Marta", 200.0, workedDays);
    }
}
