/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.controllers;


import com.nhb.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author VIP
 */
@RestController
//@RequestMapping("/api")
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class ApiTripController {
    @Autowired
    private TripService tripService;
    
    @DeleteMapping("/trips/{tripId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTrip(@PathVariable(name = "tripId") int tripId){
        this.tripService.deleteTrip(tripId);
    }
    
}
