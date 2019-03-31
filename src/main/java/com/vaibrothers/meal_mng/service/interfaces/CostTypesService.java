package com.vaibrothers.meal_mng.service.interfaces;

import com.vaibrothers.meal_mng.entity.CostTypes;

import java.util.List;

public interface CostTypesService {

    public CostTypes saveCostTypes(CostTypes costTypes);

    public List<CostTypes> list();

    public CostTypes findCostTypesByName(String costingName);

    public CostTypes update(CostTypes costTypes);


}
