/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.service.impl;

import com.nhb.pojo.Trip;
import com.nhb.repository.TripRepository;
import com.nhb.service.TripService;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 *
 * @author VIP
 */
@Service
public class TripServiceImpl implements TripService{
    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Trip> getTrips(String kw) {
        return this.tripRepository.getTrips(kw);
    }

    @Override
    public boolean deleteTrip(int TripId) {
        return this.tripRepository.deleteTrip(TripId);
    }

    @Override
    public boolean addOrUpdateTrip(Trip trp) {
        return this.tripRepository.addOrUpdateTrip(trp);
    }

    @Override
    public Trip getTripById(int i) {
        return this.tripRepository.getTripById(i);
    }
    
}
