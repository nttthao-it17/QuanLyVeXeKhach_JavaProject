/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.controllers;

import com.nhb.service.RouteService;
import com.nhb.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author VIP
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private RouteService routeService;
    @Autowired
    private TripService tripService;
    
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("routes", this.routeService.getRoute());
    }
      
    @RequestMapping("/")
    public String index(Model model, @RequestParam(name = "rouId", required = false ) String rouId){
        
        if (rouId == null)
            model.addAttribute("trips", this.tripService.getTrips(""));
        else 
            model.addAttribute("trips", this.routeService.getRouById(Integer.parseInt(rouId)).getTrips());
        return "index";
    }
    
}
