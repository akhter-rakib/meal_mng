package com.vaibrothers.meal_mng.service.interfaces;

import com.vaibrothers.meal_mng.entity.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public User findUserByEmail(String email);

    public List<User> list();

    public User update(User user);
}
