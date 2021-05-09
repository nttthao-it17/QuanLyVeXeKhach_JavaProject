/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author VIP
 */
@Entity
@Table(name="trip")
public class Trip implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String trip_description;
    private String coach_name;
    @ManyToOne
    @JoinColumn(name="route_id")
    private Route route;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the trip_description
     */
    public String getTrip_description() {
        return trip_description;
    }

    /**
     * @param trip_description the trip_description to set
     */
    public void setTrip_description(String trip_description) {
        this.trip_description = trip_description;
    }

    /**
     * @return the coach_name
     */
    public String getCoach_name() {
        return coach_name;
    }

    /**
     * @param coach_name the coach_name to set
     */
    public void setCoach_name(String coach_name) {
        this.coach_name = coach_name;
    }

    
    /**
     * @return the route
     */
    public Route getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(Route route) {
        this.route = route;
    }

}