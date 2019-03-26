package com.vaibrothers.meal_mng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

    @GetMapping(value = "/payment")
    public String payMent() {
        return "payment/payment";
    }
}
