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
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Route> getRoute() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Route");
        return q.getResultList();
    }
    
//        Route r1 = new Route();
//        r1.setId(1);
//        r1.setStation_from("Ha Noi");
//        r1.setStation_to("Lam Dong");
//        Route r2 = new Route();
//        r2.setId(2);
//        r2.setStation_from("Hai Phong");
//        r2.setStation_to("Nha Trang");
//        
//        List<Route> routes = new ArrayList<>();
//        routes.add(r1);
//        routes.add(r2);
//        
//        return routes;   

    @Override
    @Transactional
    public Route getRouById(int rouId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Route.class, rouId);
    }

    @Override
    @Transactional
    public boolean addOrUpdateRoute(Route route) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(route.getId() > 0){
            session.update(route);
        } else {
            session.save(route);
        }
            
           return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    @Transactional
    public boolean deleteRoute(int routeId) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Route.class, routeId));
           
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
            
        return false;
    }
    
}
