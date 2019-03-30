package com.vaibrothers.meal_mng.service.impl;

import com.vaibrothers.meal_mng.entity.Meal;
import com.vaibrothers.meal_mng.repository.MealRepository;
import com.vaibrothers.meal_mng.service.interfaces.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    MealRepository mealRepository;


    @Override
    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public List<Meal> list() {
        return mealRepository.findAll();
    }

    @Override
    public List<Meal> getDateWisePaymetnList(Date startDate, Date endDate) {
        return mealRepository.getDateWiseMealList(startDate, endDate);
    }

    @Override
    public Meal update(Meal meal) {
        return null;
    }
}
