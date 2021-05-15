/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.service.impl;

import com.nhb.pojo.Route;
import com.nhb.pojo.Trip;
import com.nhb.repository.RouteRepository;
import com.nhb.service.RouteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author VIP
 */
@Service
public class RouteServiceImpl implements RouteService{
    @Autowired
    private RouteRepository routeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Route> getRoutes() {
        return routeRepository.getRoutes("");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Trip> getTripByRoute(int routeId) {
        return routeRepository.getTripByRoute(routeId);
    }

    
    
}
