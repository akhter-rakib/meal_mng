package com.vaibrothers.meal_mng.restController;

import com.vaibrothers.meal_mng.entity.CostTypes;
import com.vaibrothers.meal_mng.service.interfaces.CostTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CostTypeRestController {

    @Autowired
    private CostTypesService costTypesService;

    @GetMapping(value = "/getCostTypes")
    public List<CostTypes> getCostTypes() {
        return costTypesService.list();
    }
}
