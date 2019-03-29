package com.vaibrothers.meal_mng.service.interfaces;

import com.vaibrothers.meal_mng.entity.Payment;

import java.util.Date;
import java.util.List;

public interface PaymentService {

    public Payment savePayment(Payment payment);

    public List<Payment> list();

    public List<Payment> getDateWisePaymetnList(Date startDate, Date endDate);

    public Payment update(Payment payment);
}
