package com.vaibrothers.meal_mng.restController;

import com.vaibrothers.meal_mng.entity.Meal;
import com.vaibrothers.meal_mng.entity.User;
import com.vaibrothers.meal_mng.service.interfaces.MealService;
import com.vaibrothers.meal_mng.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class MealRestController {

    @Autowired
    MealService mealService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/mealList", method = RequestMethod.GET)
    public List<Meal> getMealList() {
        return mealService.getPaymentListByMonth();
    }

    @PostMapping(value = "/saveMeal")
    public void saveMeal(@RequestBody Meal meal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = userService.findUserByEmail(auth.getName());
        meal.setCreatedBy(loggedUser);
        meal.setCreateOn(new Date());
        mealService.saveMeal(meal);
    }

}
