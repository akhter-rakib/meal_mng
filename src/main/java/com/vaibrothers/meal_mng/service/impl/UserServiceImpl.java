package com.vaibrothers.meal_mng.service.impl;

import com.vaibrothers.meal_mng.config.ActiveStatus;
import com.vaibrothers.meal_mng.entity.Role;
import com.vaibrothers.meal_mng.entity.User;
import com.vaibrothers.meal_mng.repository.RoleRepository;
import com.vaibrothers.meal_mng.repository.UserRepository;
import com.vaibrothers.meal_mng.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        user.setActive(ActiveStatus.ACTIVE.getValue());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setDateCreated(new Date());
        Role role = roleRepository.findByRole("MEAL_MEMBER");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        userRepository.save(user);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return null;
    }
}
