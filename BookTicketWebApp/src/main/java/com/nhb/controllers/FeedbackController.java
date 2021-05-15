/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.controllers;

import com.nhb.pojo.Feedback;
import com.nhb.pojo.User;
import com.nhb.service.FeedbackService;
import com.nhb.service.UserService;
import com.nhb.validator.WebAppValidator;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author T430s
 */
@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("myapp")
    private WebAppValidator feedbackValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(feedbackValidator);
    }

    @RequestMapping(value = "/feedback")
    public String feedbackView(Model model,
            @RequestParam(name = "description", required = false) String description) {
        model.addAttribute("feedback", feedbackService.getFeedbacks(""));

        return "feedback";
    }

    @RequestMapping(value = "/feedback/add")
    public String addFeedbackView(Model model,
            @RequestParam(name = "user_id", required = false, defaultValue = "0") int feedbackId) {
        model.addAttribute("user", userService.getUserById(feedbackId));

        return "addfeedback";
    }

    @GetMapping(value = "/feedback/add")
    public String addFeedbackView(Model model) {
        
        Feedback feedback = new Feedback();
        model.addAttribute("addFeedback", feedback);
        return "addfeedback";
    }

    @PostMapping(value = "/feedback/add")
    public String addFeedbackProcess(Model model,
            @ModelAttribute(value = "addFeedback") @Valid Feedback fb,       
            BindingResult result, HttpServletRequest request) {
        User userId = userService.getUserById(4);
        fb.setUser(userId);
        if (result.hasErrors()) {
            return "addfeedback";
        }
        feedbackService.addFeedback(fb);

        return "redirect:/";
    }
}
