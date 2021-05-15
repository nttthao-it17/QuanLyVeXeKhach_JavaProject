/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.service;

import com.nhb.pojo.Route;
import java.util.List;

/**
 *
 * @author VIP
 */
public interface RouteService {
    List<Route> getRoute();
    Route getRouById(int rouId);
    boolean addOrUpdateRoute(Route route);
    boolean deleteRoute(int RouteId);
    
}
