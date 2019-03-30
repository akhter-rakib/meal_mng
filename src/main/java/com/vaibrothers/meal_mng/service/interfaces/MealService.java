package com.vaibrothers.meal_mng.service.interfaces;

import com.vaibrothers.meal_mng.entity.Meal;

import java.util.Date;
import java.util.List;

public interface MealService {

    public Meal saveMeal(Meal meal);

    public List<Meal> list();

    public List<Meal> getDateWisePaymetnList(Date startDate, Date endDate);

    public Meal update(Meal meal);
}
