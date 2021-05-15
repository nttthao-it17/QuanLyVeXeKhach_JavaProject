/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository.impl;

import com.nhb.pojo.BookingTicket;
import com.nhb.repository.BookingTicketRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author T430s
 */
@Repository
public class BookingTicketRepositoryImpl implements BookingTicketRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBookingTicket(BookingTicket booking) {
        Session session = sessionFactory.getCurrentSession();
        session.save(booking);
    }

}
