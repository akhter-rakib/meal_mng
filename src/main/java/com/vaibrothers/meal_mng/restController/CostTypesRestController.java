package com.vaibrothers.meal_mng.restController;

import com.vaibrothers.meal_mng.entity.CostTypes;
import com.vaibrothers.meal_mng.entity.User;
import com.vaibrothers.meal_mng.service.interfaces.CostTypesService;
import com.vaibrothers.meal_mng.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CostTypesRestController {

    @Autowired
    CostTypesService costTypesService;

    @Autowired
    UserService userService;

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
