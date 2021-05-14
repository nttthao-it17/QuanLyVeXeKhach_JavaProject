/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.controllers;

import com.nhb.pojo.Trip;
import com.nhb.service.RouteService;
import com.nhb.service.TripService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 *
 * @author VIP
 */
@Controller
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;
    @Autowired
    private RouteService routeService;
   
    
    
    @RequestMapping("/trip")
    public String product(Model model) {
        model.addAttribute("routes", this.routeService.getRoute());
        model.addAttribute("trip", new Trip());
        return "trip";
    }
    
    @RequestMapping("/trip/{tripId}")
    public String product(Model model, 
            @PathVariable(name = "tripId") int tripId) {
        model.addAttribute("routes", this.routeService.getRoute());
        model.addAttribute("trip", this.tripService.getTripById(tripId));
        return "trip";
    }
    
    @RequestMapping("/")
    public String addView(Model model,
            @RequestParam(name= "tripId", 
                    required = false, 
                    defaultValue = "0") int tripId){
        if (tripId > 0)
            model.addAttribute("trip", this.tripService.getTripById(tripId));
        else
            model.addAttribute("trip", new Trip());
        
        return "trip";
    }
    
    @PostMapping("/add")
    public String addTrip(Model model,
            @ModelAttribute(value = "trip") @Valid Trip p,
            BindingResult result) {
        if (result.hasErrors()){
            return "trip";
        }
        
        if (!this.tripService.addOrUpdateTrip(p)){
            model.addAttribute("erroMsg","Something wrong!!!");
            return "trip";
        }
        
        return "redirect:/";
    }
    
}
