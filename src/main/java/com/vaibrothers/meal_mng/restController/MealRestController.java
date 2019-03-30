package com.vaibrothers.meal_mng.restController;

import com.vaibrothers.meal_mng.entity.Meal;
import com.vaibrothers.meal_mng.entity.User;
import com.vaibrothers.meal_mng.service.interfaces.MealService;
import com.vaibrothers.meal_mng.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MealRestController {

    @Autowired
    MealService mealService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/saveMeal")
    public void saveMeal(@RequestBody Meal meal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = userService.findUserByEmail(auth.getName());
        meal.setCratedBy(loggedUser);
        meal.setCreateOn(new Date());
        mealService.saveMeal(meal);
    }

}
