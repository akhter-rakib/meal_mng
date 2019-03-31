package com.vaibrothers.meal_mng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CostTypesController {

    @GetMapping(value = "/costingTypes")
    public String getCostTypesEntryPage() {
        return "costTypes/costTypes";
    }
}
