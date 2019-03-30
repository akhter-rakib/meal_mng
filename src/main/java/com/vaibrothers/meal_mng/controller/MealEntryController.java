package com.vaibrothers.meal_mng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MealEntryController {

    @GetMapping(value = "/mealEntry")
    public String getMealEntryPage() {
        return "mealentry/mealEntry";
    }
}
