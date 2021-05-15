/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository.impl;

import com.nhb.pojo.BookingTicket;
import com.nhb.pojo.TicketDetail;
import com.nhb.repository.TicketRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author VIP
 */
@Repository
public class TicketRepositoryImpl implements TicketRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

//    @Override
//    @Transactional
//    public List<Object[]> getStats(Date fromDate, Date toDate) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
//        
//        Root rootTicket = query.from(BookingTicket.class);
//        Root rootDetails = query.from(TicketDetail.class);
//        query = query.where(builder.equal(rootTicket.get("id"), rootDetails.get("bookingTicket")));
//        
//        query.multiselect(rootTicket.get("id"), 
//                rootTicket.get("totalAmount").as(BigDecimal.class),
//                rootTicket.get("createdDate").as(Date.class),
//                builder.count(rootDetails.get("id")));
//        query.groupBy(rootTicket.get("id"), 
//                rootTicket.get("totalAmount").as(BigDecimal.class),
//                rootTicket.get("createdDate").as(Date.class));
//        
//        if (fromDate != null && toDate != null){
//            Predicate p1 = builder.greaterThanOrEqualTo(rootTicket.get("createdDate").as(Date.class), fromDate);
//            Predicate p2 = builder.lessThanOrEqualTo(rootTicket.get("createdDate").as(Date.class), toDate);
//            query = query.having(p1,p2);
//        }
//        
//        
//        Query q = session.createQuery(query);
//        return q.getResultList();
//    }

    @Override
    @Transactional
    public List<Object[]> getTicketStats(Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        
        Root orderRoot = query.from(BookingTicket.class);
        Root detailRoot = query.from(TicketDetail.class);
        
        query = query.where(builder.equal(orderRoot.get("id"), detailRoot.get("bookingTicket")));
        query.multiselect(orderRoot.get("id"), 
                orderRoot.get("amount").as(BigDecimal.class),
                orderRoot.get("createdDate").as(Date.class),
                builder.count(detailRoot.get("id")));
        query.groupBy(orderRoot.get("id"), 
                orderRoot.get("amount").as(BigDecimal.class),
                orderRoot.get("createdDate").as(Date.class));
        
        if (fromDate != null && toDate != null) {
            Predicate p1 = builder.greaterThanOrEqualTo(
                    orderRoot.get("datePay").as(Date.class), fromDate);
            Predicate p2 = builder.lessThanOrEqualTo(
                    orderRoot.get("datePay").as(Date.class), toDate);
            query = query.having(p1, p2);
        }
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }
    
}
