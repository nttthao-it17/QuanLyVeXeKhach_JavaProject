/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository.impl;

import com.nhb.pojo.Route;
import com.nhb.pojo.Trip;
import com.nhb.repository.RouteRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author VIP
 */
@Repository
public class RouteRepositoryImpl implements RouteRepository{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Route> getRoutes(String kw) {
        List<Route> routes;
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Route> cr = builder.createQuery(Route.class);
        Root<Route> root = cr.from(Route.class);

        CriteriaQuery query = cr.select(root);
        if (!kw.isEmpty())
            query = query.where(builder.like(root.get("station_from").as(String.class),  
                    "%" + kw + "%"));

        routes = session.createQuery(query).getResultList();        
        return routes;
    }

    @Override
    public Route getRouteById(int id) {
        Route route;
        Session session = sessionFactory.getCurrentSession();
        route = session.get(Route.class, id);
        
        return route;
    }

    @Override
    public List<Trip> getTripByRoute(int tripId) {
        List<Trip> trips = null;
        Session session = sessionFactory.getCurrentSession(); 
        Route route = session.get(Route.class, tripId);
        if (route != null) {
            Hibernate.initialize(route.getTrips());
            trips = route.getTrips();
        }

        return trips;
    }
}
