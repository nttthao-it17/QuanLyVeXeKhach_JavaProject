/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author VIP
 */
public interface TicketRepository {
    List<Object[]> getTicketStats(Date fromDate, Date toDate);
}
