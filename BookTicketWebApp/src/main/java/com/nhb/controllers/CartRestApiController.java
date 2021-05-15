/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.controllers;

import com.nhb.pojo.Cart;
import com.nhb.service.BookingTicketService;
import com.nhb.service.TripService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author T430s
 */
@RestController
@RequestMapping(value = "/api/cart")
public class CartRestApiController {
    @Autowired
    private TripService tripService;
    @Autowired
    private BookingTicketService bookingService;
    
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addOrUpdate(HttpSession session,
            @RequestParam(value = "tripId") int tripId,
            @RequestParam(value = "num") int num) {
        Map<Integer, Cart> d;
        if (session.getAttribute("cart") == null) 
            d = new HashMap<>();
        else
            d = (Map<Integer, Cart>) session.getAttribute("cart");
        
        Cart c;
        if (d.containsKey(tripId) == true) {
            c = d.get(tripId);
            c.setNum(c.getNum() + 1);
        } else {
            c = new Cart(tripService.getTripById(tripId), num);
        }
        
        d.put(tripId, c);
        
        session.setAttribute("cart", d);
    }
    
    @PostMapping(value = "/pay")
    @ResponseStatus(value = HttpStatus.OK)
    public void payCart(HttpSession session) {   
        Map<Integer, Cart> carts 
                = (Map<Integer, Cart>) session.getAttribute("cart");
        bookingService.addBookingTicket(carts.values());
        
        session.removeAttribute("cart");
    }
    
    @PostMapping(value = "/{tripId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathParam(value = "tripId") String tripId, 
            HttpSession session) {
        if (session.getAttribute(tripId) != null)
            session.removeAttribute(tripId);
    }
}
