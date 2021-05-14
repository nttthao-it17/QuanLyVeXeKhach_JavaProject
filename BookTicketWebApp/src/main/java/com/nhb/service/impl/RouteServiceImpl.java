/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.service.impl;

import com.nhb.pojo.Route;
import com.nhb.repository.RouteRepository;
import com.nhb.service.RouteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author VIP
 */
@Service
public class RouteServiceImpl implements RouteService{
    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> getRoute() {
        return this.routeRepository.getRoute();
    }

    @Override
    public Route getRouById(int id) {
        return this.routeRepository.getRouById(id);
    }

    @Override
    public boolean addOrUpdateRoute(Route rou) {
        return this.routeRepository.addOrUpdateRoute(rou);
    }

    @Override
    public boolean deleteRoute(int RouteId) {
        return this.routeRepository.deleteRoute(RouteId);
    }
    
}
