/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.service.impl;

import com.nhb.pojo.Feedback;
import com.nhb.repository.FeedbackRepository;
import com.nhb.service.FeedbackService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getFeedbacks(String kw) {
        return feedbackRepository.getFeedbacks(kw);
    }

    @Override
    @Transactional(readOnly = true)
    public Feedback getFeedbackById(int feedbackId) {
        return feedbackRepository.getFeedbackById(feedbackId);
    }

    @Override
    @Transactional
    public void addFeedback(Feedback feedback) {
//        String des = feedback.getDescription();
//        Date createdDate = feedback.getCreatedDate();
//        if (!des.isEmpty() && createdDate.toString().isEmpty()) {
//            feedbackRepository.addFeedback(feedback);
//        }
        feedbackRepository.addFeedback(feedback);
    }

}
