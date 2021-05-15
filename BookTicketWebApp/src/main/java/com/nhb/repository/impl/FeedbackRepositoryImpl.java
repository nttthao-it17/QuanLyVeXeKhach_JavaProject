/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository.impl;

import com.nhb.pojo.Feedback;
import com.nhb.repository.FeedbackRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Feedback> getFeedbacks(String kw) {
        List<Feedback> fbs;
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Feedback> cr = builder.createQuery(Feedback.class);
        Root<Feedback> root = cr.from(Feedback.class);

        CriteriaQuery<Feedback> query = cr.select(root);
        if (!kw.isEmpty()) {
            String pattern = String.format("%%%s%%", kw);
            Predicate p1 = builder.like(root.get("description").as(String.class), pattern);

            query = query.where(builder.or(p1));
        }

        fbs = session.createQuery(query).getResultList();

        return fbs;
    }

    @Override
    public void addFeedback(Feedback fb) {
        Session session = sessionFactory.getCurrentSession();
        session.save(fb);
    }

    @Override
    public Feedback getFeedbackById(int id) {
        Feedback fb;
        
        Session session = sessionFactory.getCurrentSession();
        fb = session.get(Feedback.class, id);
        
        return fb;
    }
    
}
