package com.vaibrothers.meal_mng.restController;

import com.vaibrothers.meal_mng.entity.CostTypes;
import com.vaibrothers.meal_mng.entity.User;
import com.vaibrothers.meal_mng.service.interfaces.CostTypesService;
import com.vaibrothers.meal_mng.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class CostTypesRestController {

    @Autowired
    CostTypesService costTypesService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/getCostTypes")
    public List<CostTypes> getCostTypes() {
        return costTypesService.list();
    }

    @PostMapping(value = "/saveCostingTypes")
    public void saveCostTypes(@RequestBody CostTypes costTypes){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser;
        loggedUser = userService.findUserByEmail(authentication.getName());
        costTypes.setCreatedBy(loggedUser);
        costTypes.setCreatedOn(new Date());
        costTypesService.saveCostTypes(costTypes);
    }



}
