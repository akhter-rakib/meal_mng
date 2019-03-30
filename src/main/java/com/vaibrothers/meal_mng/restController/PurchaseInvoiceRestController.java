package com.vaibrothers.meal_mng.restController;

import com.vaibrothers.meal_mng.entity.PurchaseInvoice;
import com.vaibrothers.meal_mng.entity.User;
import com.vaibrothers.meal_mng.service.interfaces.PurchaseInvoiceService;
import com.vaibrothers.meal_mng.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PurchaseInvoiceRestController {

    @Autowired
    UserService userService;

    @Autowired
    PurchaseInvoiceService purchaseInvoiceService;

    @PostMapping(value = "/savePurchaseInvoice")
    public void savePayment(@RequestBody PurchaseInvoice purchaseInvoice) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = userService.findUserByEmail(auth.getName());
        purchaseInvoice.setCreatedBy(loggedUser);
        purchaseInvoice.setCreatedOn(new Date());
        purchaseInvoiceService.savePurchase(purchaseInvoice);
    }
}
