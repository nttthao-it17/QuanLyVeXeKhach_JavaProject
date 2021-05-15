/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository;

import com.nhb.pojo.Trip;
import java.util.List;

/**
 *
 * @author VIP
 */
public interface TripRepository {
    List<Trip> getTrips(String kw);
    boolean deleteTrip(int TripId);
    boolean addOrUpdateTrip(Trip p);
    Trip getTripById(int tripId);
}
