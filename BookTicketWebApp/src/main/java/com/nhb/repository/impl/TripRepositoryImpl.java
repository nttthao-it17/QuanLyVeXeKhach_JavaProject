/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository.impl;

import com.nhb.pojo.Trip;
import com.nhb.repository.TripRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 *
 * @author VIP
 */
@Repository
public class TripRepositoryImpl implements TripRepository{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Trip> getTrips(String kw) {
        List<Trip> trips;
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> cr = builder.createQuery(Trip.class);
        Root<Trip> root = cr.from(Trip.class);

        CriteriaQuery<Trip> query = cr.select(root);
        if (!kw.isEmpty()) {
            String pattern = String.format("%%%s%%", kw);
            Predicate p1 = builder.like(root.get("trip_description").as(String.class), pattern);
            Predicate p2 = builder.like(root.get("coach_name").as(String.class), pattern);

            query = query.where(builder.or(p1, p2));
        }

        trips = session.createQuery(query).getResultList();

        return trips;
    }

//    @Override
//    public List<Trip> getTripsByPrice(BigDecimal fromPrice, BigDecimal toPrice) {
//        List<Trip> trips;
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Trip> cr = builder.createQuery(Trip.class);
//        Root<Trip> root = cr.from(Trip.class);
//
//        CriteriaQuery query = cr.select(root);
//
//        Predicate p1 = builder.greaterThanOrEqualTo(root.get("price").as(BigDecimal.class), fromPrice);
//        Predicate p2 = builder.lessThanOrEqualTo(root.get("price").as(BigDecimal.class), toPrice);
//
//        query = query.where(builder.and(p1, p2));
//
//        trips = session.createQuery(query).getResultList();
//        
//        return trips;
//    }

    @Override
    public Trip getTripsById(int id) {
        Trip trip;
        
        Session session = sessionFactory.getCurrentSession();
        trip = session.get(Trip.class, id);
        
        return trip;
    }

    @Override
    public boolean checkTripDescription(String tripDescription) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> cr = builder.createQuery(Trip.class);

        Root<Trip> root = cr.from(Trip.class);
        CriteriaQuery query = cr.select(root);            
        query.where(builder.equal(builder.upper(root.get("trip_description").as(String.class)), 
                tripDescription.toUpperCase()));

        return session.createQuery(query).getSingleResult() == null;
    }

}
