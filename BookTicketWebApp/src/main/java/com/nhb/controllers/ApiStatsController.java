///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.nhb.controllers;
//
//import com.nhb.service.TicketService;
//import java.util.List;
//import jdk.internal.net.http.frame.Http2Frame;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
///**
// *
// * @author VIP
// */
//@RestController
//@RequestMapping("/api")
//public class ApiStatsController {
//    @Autowired
//    private TicketService ticketService;
//    
//    @GetMapping("/stats")
//    public ResponseEntity<List<Object[]>> getStats() {
//        return new ResponseEntity<>(this.ticketService.getStats(null, null), HttpStatus.OK);
//    }
//}
