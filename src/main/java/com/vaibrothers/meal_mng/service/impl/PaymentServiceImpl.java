package com.vaibrothers.meal_mng.service.impl;

import com.vaibrothers.meal_mng.entity.Payment;
import com.vaibrothers.meal_mng.repository.PaymentRepository;
import com.vaibrothers.meal_mng.service.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> list() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getDateWisePaymetnList(Date startDate, Date endDate) {
        return paymentRepository.getDateWisePaymetnList(startDate, endDate);
    }

    @Override
    public List<Payment> getPaymentListByMonth() {
        return paymentRepository.getPaymentListByMonth();
    }

    @Override
    public Payment update(Payment payment) {
        return null;
    }
}
