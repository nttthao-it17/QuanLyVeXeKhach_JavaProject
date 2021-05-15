/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.service.impl;

import com.nhb.pojo.BookingTicket;
import com.nhb.pojo.Cart;
import com.nhb.pojo.TicketDetail;
import com.nhb.pojo.User;
import com.nhb.repository.BookingTicketRepository;
import com.nhb.repository.TicketDetailRepository;
import com.nhb.service.BookingTicketService;
import com.nhb.service.UserService;
import java.math.BigDecimal;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author T430s
 */
@Service
public class BookingTicketServiceImpl implements BookingTicketService{
    @Autowired
    private BookingTicketRepository bookingRepository;
    @Autowired
    private TicketDetailRepository ticketRepository;
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void addBookingTicket(Collection<Cart> carts) {
        BigDecimal sum = new BigDecimal(0);
        
        for (Cart c: carts)
            sum = sum.add(c.getTrip()
                           .getPrice()
                           .multiply(new BigDecimal(c.getNum())));
     
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByUsername(username);
        
        BookingTicket booking = new BookingTicket(sum, user);
        bookingRepository.addBookingTicket(booking);

        for (Cart c: carts) {
            TicketDetail ticket = new TicketDetail(booking, c.getTrip(), c.getNum());
            ticketRepository.addTicketDetail(ticket);
        }
    }
}
