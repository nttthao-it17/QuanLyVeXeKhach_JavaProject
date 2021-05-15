/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.service;

import com.nhb.pojo.Route;
import com.nhb.pojo.Trip;
import java.util.List;

/**
 *
 * @author VIP
 */
public interface RouteService {
    List<Route> getRoutes();
    List<Trip> getTripByRoute(int routeId);
    
}
