package com.vaibrothers.meal_mng.restController;

import com.vaibrothers.meal_mng.entity.Payment;
import com.vaibrothers.meal_mng.entity.User;
import com.vaibrothers.meal_mng.service.interfaces.PaymentService;
import com.vaibrothers.meal_mng.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentRestController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/savePayment")
    public void savePayment(@RequestBody Payment payment) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = userService.findUserByEmail(auth.getName());
        payment.setCratedBy(loggedUser);
        paymentService.savePayment(payment);
    }

    @GetMapping(value = "/testRest")
    public String test() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = userService.findUserByEmail(auth.getName());
        System.out.println("***********************************" + loggedUser.getId());
        return "";
    }

}
