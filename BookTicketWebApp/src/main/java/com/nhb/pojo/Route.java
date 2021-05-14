/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author VIP
 */
@Entity
@Table(name="route")
public class Route implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String station_from;
    private String station_to;
    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    private List<Trip> trips;

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    

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
     * @return the station_from
     */
    public String getStation_from() {
        return station_from;
    }

    /**
     * @param station_from the station_from to set
     */
    public void setStation_from(String station_from) {
        this.station_from = station_from;
    }

    /**
     * @return the station_to
     */
    public String getStation_to() {
        return station_to;
    }

    /**
     * @param station_to the station_to to set
     */
    public void setStation_to(String station_to) {
        this.station_to = station_to;
    }

    /**
     * @return the trips
     */
    public List<Trip> getTrips() {
        return trips;
    }

    /**
     * @param trips the trips to set
     */
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
