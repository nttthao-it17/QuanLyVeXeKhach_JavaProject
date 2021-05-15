/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.controllers;

import com.nhb.pojo.User;
import com.nhb.service.UserService;
import com.nhb.validator.WebAppValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author T430s
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("myapp")
    private WebAppValidator userValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }
    
    @GetMapping(value = "/login")
    public String loginView(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    
//    @PostMapping(value = "/submit_login")
//    public String submitLogin(){
//        //Thông tin username mật khẩu được nhập từ dưới front end
//        
//        //Tìm trong database từ username và mật khẩu để lấy thông user
//        //user bắt buộc phải có role để phân quyền
//        //tự quy định. Role = 1: admin  Role = 2: user
//        //tạm thời gán cứng userRole = 1
//        //username và password tạm thời gán cứng
//        //Phải lấy từ front end mapping vào
//        
//        
//        String username = "";
//        String password = "";
//        User user = userService.login(username, password);
//        if(user != null){
//            String userRole = user.getUserRole();
//            if(userRole.equals("")){
//                return "TrangAdmin";
//            }else{
//                return "TrangUser";
//            }
//        }
//        return "/";
//    }
    
    @GetMapping(value = "/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping(value = "/register")
    public String registerProcess(@ModelAttribute(name = "user") @Valid User user, 
            BindingResult result) {
        if (result.hasErrors()) 
            return "register";
        
        userService.addUser(user);
        
        return "redirect:/login";
    }
}
