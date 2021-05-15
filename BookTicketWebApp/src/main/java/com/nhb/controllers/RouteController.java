/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.controllers;

import com.nhb.pojo.Route;
import com.nhb.pojo.Trip;
import com.nhb.service.RouteService;
import com.nhb.service.TripService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouteService routeService;
   
    
    
    @RequestMapping("/route")
    public String route(Model model) {
        model.addAttribute("routes", this.routeService.getRoute());
        return "route";
    }
    
    @RequestMapping("/route/{routeId}")
    public String route(Model model, 
            @PathVariable(name = "routeId") int routeId) {
        model.addAttribute("route", this.routeService.getRouById(routeId));
        return "route";
    }
    
    @RequestMapping("/")
    public String addView(Model model,
            @RequestParam(name= "routeId", 
                    required = false, 
                    defaultValue = "0") int routeId){
        if (routeId > 0)
            model.addAttribute("route", this.routeService.getRouById(routeId));
        else
            model.addAttribute("route", new Route());
        
        return "route";
    }
    
    
    
    @PostMapping("/add")
    public String addRoute(Model model,
            @ModelAttribute(value = "route") @Valid Route r,
            BindingResult result) {
        if (result.hasErrors()){
            return "route";
        }
        
        if (!this.routeService.addOrUpdateRoute(r)){
            model.addAttribute("erroMsg","Something wrong!!!");
            return "route";
        }
        
        return "redirect:/";
    }
    
}
