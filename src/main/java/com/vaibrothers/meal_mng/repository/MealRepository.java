package com.vaibrothers.meal_mng.repository;

import com.vaibrothers.meal_mng.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

    @Query("select meal from Meal meal where meal.meal_date between :startDate and :endDate")
    public List<Meal> getDateWiseMealList(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
