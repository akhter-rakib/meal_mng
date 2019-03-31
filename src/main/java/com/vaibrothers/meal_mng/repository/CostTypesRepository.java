package com.vaibrothers.meal_mng.repository;

import com.vaibrothers.meal_mng.entity.CostTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostTypesRepository extends JpaRepository<CostTypes, Integer> {
    CostTypes findByCostingName(String costingName);
}
