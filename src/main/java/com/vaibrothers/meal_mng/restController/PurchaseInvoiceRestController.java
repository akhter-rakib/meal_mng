package com.vaibrothers.meal_mng.restController;

import com.vaibrothers.meal_mng.entity.PurchaseInvoice;
import com.vaibrothers.meal_mng.entity.User;
import com.vaibrothers.meal_mng.service.interfaces.PurchaseInvoiceService;
import com.vaibrothers.meal_mng.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PurchaseInvoiceRestController {

    @Autowired
    UserService userService;

    @Autowired
    PurchaseInvoiceService purchaseInvoiceService;

    @RequestMapping(value = "/purchaseList", method = RequestMethod.GET)
    public List<PurchaseInvoice> getPurchaseList() {
        return purchaseInvoiceService.getPaymentListByMonth();
    }
    @PostMapping(value = "/savePurchaseInvoice")
    public void savePayment(@RequestBody PurchaseInvoice purchaseInvoice) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = userService.findUserByEmail(auth.getName());
        purchaseInvoice.setCreatedBy(loggedUser);
        purchaseInvoice.setCreatedOn(new Date());
        purchaseInvoiceService.savePurchase(purchaseInvoice);
    }
}
