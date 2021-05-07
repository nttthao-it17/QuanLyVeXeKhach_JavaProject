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
    private int amount_of_trip_on_day;
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
     * @return the amount_of_trip_on_day
     */
    public int getAmount_of_trip_on_day() {
        return amount_of_trip_on_day;
    }

    /**
     * @param amount_of_trip_on_day the amount_of_trip_on_day to set
     */
    public void setAmount_of_trip_on_day(int amount_of_trip_on_day) {
        this.amount_of_trip_on_day = amount_of_trip_on_day;
    }

    
   
     
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
