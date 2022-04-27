package com.rodrigocbarj.hrpayroll.services;

import com.rodrigocbarj.hrpayroll.entities.Payment;
import com.rodrigocbarj.hrpayroll.entities.Worker;
import com.rodrigocbarj.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int workedDays) {

        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), workedDays);
    }
}
