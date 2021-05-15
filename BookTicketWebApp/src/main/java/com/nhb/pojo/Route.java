/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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
    private static long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "station_from")
    private String stationFrom;
    
    @Column(name = "station_to")
    private String stationTo;
    
    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    private List<Trip> trips;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
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

    /**
     * @return the stationFrom
     */
    public String getStationFrom() {
        return stationFrom;
    }

    /**
     * @param stationFrom the stationFrom to set
     */
    public void setStationFrom(String stationFrom) {
        this.stationFrom = stationFrom;
    }

    /**
     * @return the stationTo
     */
    public String getStationTo() {
        return stationTo;
    }

    /**
     * @param stationTo the stationTo to set
     */
    public void setStationTo(String stationTo) {
        this.stationTo = stationTo;
    }

    
}
