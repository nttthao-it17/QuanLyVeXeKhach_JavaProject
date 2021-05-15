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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author VIP
 */
@Service
@Transactional
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Trip> getTrips(String kw) {
        return tripRepository.getTrips(kw);

    }

    @Override
    @Transactional(readOnly = true)
    public Trip getTripById(int tripId) {
        return tripRepository.getTripsById(tripId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkTripDescription(String tripDescription) {
        return tripRepository.checkTripDescription(tripDescription);
    }

}
