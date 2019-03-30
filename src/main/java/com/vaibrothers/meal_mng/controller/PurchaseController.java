package com.vaibrothers.meal_mng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PurchaseController {

    @GetMapping(value = "/purchase")
    public String purchase() {
        return "purchaseInvoice/purchaseInvoice";
    }
}
