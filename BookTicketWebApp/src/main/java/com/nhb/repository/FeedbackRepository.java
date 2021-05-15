/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository;

import com.nhb.pojo.Feedback;
import java.util.List;

/**
 *
 * @author T430s
 */
public interface FeedbackRepository {
    List<Feedback> getFeedbacks(String kw);
    Feedback getFeedbackById(int id);
    void addFeedback(Feedback fb);
    
}
