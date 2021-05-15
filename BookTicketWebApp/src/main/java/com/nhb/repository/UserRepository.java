/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository;

import com.nhb.pojo.User;
import java.util.List;

/**
 *
 * @author T430s
 */
public interface UserRepository {
    void addUser(User user);
    List<User> getUsers(String username);
    User getUserById(int userId);
    
    User login(String username, String password);
}
