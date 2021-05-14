/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.controllers;

import com.nhb.service.TicketService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author VIP
 */
@Controller
public class TicketController {
    @Autowired
    private SimpleDateFormat simpleDateFormat;
    @Autowired
    private TicketService ticketService;
    
    @GetMapping("/stats")
    public String stats(Model model,
            @RequestParam(name = "fromDate", required = false) String fromDate,
            @RequestParam(name = "toDate", required = false) String toDate) {
        
        Date fr = null, to = null;
        try {
            fr = this.simpleDateFormat.parse(fromDate);
            to = this.simpleDateFormat.parse(toDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        List<Object[]> dataStats = this.ticketService.getTicketStats(fr, to);
        List<BigDecimal> amounts = new ArrayList<>();
        for (Object[] d: dataStats)
            amounts.add((BigDecimal) d[1]);
        
        
        model.addAttribute("dataStats", dataStats);
        model.addAttribute("amounts", amounts);
        
        return "stats";
    }
    
}
