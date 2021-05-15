/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author VIP
 */
@Entity
@Table(name="trip")
public class Trip implements Serializable{
    
    private static long serialVersionUID = 2L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "trip_description")
    private String tripDescription;
    
    @Column(name = "coach_name")
    private String coachName;
 
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "date_started")
    private Date dateStarted;
    
    @Temporal(javax.persistence.TemporalType.TIME)
    @Column(name = "time_started")
    private Date timeStarted;

    @Column(name = "price")
    private BigDecimal price;
    
    @ManyToOne
    @JoinColumn(name="route_id")
    private Route route;
    
    @OneToMany(mappedBy = "trip", fetch = FetchType.EAGER)
    private List<TicketDetail> tickets;

    public Trip() {
        
    }
    
    public Trip(String tripDescription, BigDecimal price, Date dateStarted) {
        this.tripDescription = tripDescription;
        this.price = price;
        this.dateStarted = dateStarted;
    }

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
     * @return the tripDescription
     */
    public String getTripDescription() {
        return tripDescription;
    }

    /**
     * @param tripDescription the tripDescription to set
     */
    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    /**
     * @return the coachName
     */
    public String getCoachName() {
        return coachName;
    }

    /**
     * @param coachName the coachName to set
     */
    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    /**
     * @return the dateStarted
     */
    public Date getDateStarted() {
        return dateStarted;
    }

    /**
     * @param dateStarted the dateStarted to set
     */
    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    /**
     * @return the timeStarted
     */
    public Date getTimeStarted() {
        return timeStarted;
    }

    /**
     * @param timeStarted the timeStarted to set
     */
    public void setTimeStarted(Date timeStarted) {
        this.timeStarted = timeStarted;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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

    /**
     * @return the tickets
     */
    public List<TicketDetail> getTickets() {
        return tickets;
    }

    /**
     * @param tickets the tickets to set
     */
    public void setTickets(List<TicketDetail> tickets) {
        this.tickets = tickets;
    }

    
}
