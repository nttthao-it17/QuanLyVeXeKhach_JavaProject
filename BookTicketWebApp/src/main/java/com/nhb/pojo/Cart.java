/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.pojo;

import java.io.Serializable;

/**
 *
 * @author T430s
 */
public class Cart implements Serializable{
    private Trip trip;
    private int num;
    
    public Cart() {
        
    }
    
    public Cart(Trip trip) {
        this.trip = trip;
    }
    
    public Cart(Trip trip, int num) {
        this(trip);
        this.num = num;
    }

    /**
     * @return the trip
     */
    public Trip getTrip() {
        return trip;
    }

    /**
     * @param trip the trip to set
     */
    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }
}
