/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository.impl;

import com.nhb.pojo.Trip;
import com.nhb.repository.TripRepository;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class TripRepositoryImpl implements TripRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Trip> getTrips(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root root = query.from(Trip.class);
        query.select(root);
        
        if (kw != null && !kw.isEmpty()){
            Predicate p = builder.like(root.get("name").as(String.class),
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public boolean deleteTrip(int tripId) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Trip.class, tripId));
           
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
            
        return false;
    }

    @Override
    @Transactional
    public boolean addOrUpdateTrip(Trip trip) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(trip.getId() > 0){
            session.update(trip);
        } else {
            session.save(trip);
        }
            
           return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    @Transactional
    public Trip getTripById(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Trip.class, i);
    }
    
}
