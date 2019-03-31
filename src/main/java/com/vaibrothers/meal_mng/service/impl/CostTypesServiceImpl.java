package com.vaibrothers.meal_mng.service.impl;

import com.vaibrothers.meal_mng.entity.CostTypes;
import com.vaibrothers.meal_mng.repository.CostTypesRepository;
import com.vaibrothers.meal_mng.service.interfaces.CostTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostTypesServiceImpl implements CostTypesService {

    @Autowired
    CostTypesRepository costTypesRepository;

    @Override
    public CostTypes saveCostTypes(CostTypes costTypes) {
        return costTypesRepository.save(costTypes);
    }

    @Override
    public List<CostTypes> list() {
        return costTypesRepository.findAll();
    }

    @Override
    public CostTypes findCostTypesByName(String costingName) {
        return costTypesRepository.findByCostingName(costingName);
    }

    @Override
    public CostTypes update(CostTypes costTypes) {
        return null;
    }
}
