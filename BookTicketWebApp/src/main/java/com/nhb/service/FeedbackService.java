/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.service;

import com.nhb.pojo.Feedback;
import java.util.List;

/**
 *
 * @author T430s
 */
public interface FeedbackService {
    List<Feedback> getFeedbacks(String kw);
    Feedback getFeedbackById(int feedbackId);
    void addFeedback(Feedback feedback);

}
