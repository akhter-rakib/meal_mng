package com.vaibrothers.meal_mng.restController;

import com.vaibrothers.meal_mng.entity.User;
import com.vaibrothers.meal_mng.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/getUserList")
    public List<User> getUserList() {
        return userService.list();

    }
}
