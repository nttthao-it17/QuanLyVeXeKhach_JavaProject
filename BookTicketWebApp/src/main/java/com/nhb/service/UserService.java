/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.service;

import com.nhb.pojo.Feedback;
import com.nhb.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;

/**
 *
 * @author T430s
 */
public interface UserService extends UserDetailsService{
    void addUser(User user);
    User getUserByUsername(String username);
    User getUserById(int userId);
    
    User login(String username, String password);
}
