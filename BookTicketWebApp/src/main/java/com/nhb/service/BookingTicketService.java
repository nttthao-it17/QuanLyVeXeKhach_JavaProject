/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.service;

import com.nhb.pojo.Cart;
import java.util.Collection;

/**
 *
 * @author T430s
 */
public interface BookingTicketService {
    void addBookingTicket(Collection<Cart> carts);
}
