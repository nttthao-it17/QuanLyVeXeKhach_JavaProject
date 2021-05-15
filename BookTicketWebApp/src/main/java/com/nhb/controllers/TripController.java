/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.controllers;

import com.nhb.service.RouteService;
import com.nhb.service.TripService;
import com.nhb.validator.WebAppValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VIP
 */
@Controller
@ControllerAdvice
public class TripController {
    //    ĐỂ THÊM, SỬA, XÓA CHUYẾN

    @Autowired
    private TripService tripService;
    
    @Autowired
    @Qualifier("myapp")
    private WebAppValidator tripValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(tripValidator);
    }
    
    //PAGE TRIP DETAIL
    @GetMapping(value = "/trips/{trip_id}")
    public ModelAndView detail(@PathVariable(value = "trip_id") int tripId) {
        ModelAndView view = new ModelAndView();
        view.setViewName("detail");
        view.addObject("trip", tripService.getTripById(tripId));
        
        return view;
    }
}
