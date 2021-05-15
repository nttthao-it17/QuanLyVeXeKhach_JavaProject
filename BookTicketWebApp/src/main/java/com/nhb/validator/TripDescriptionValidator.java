/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.validator;

import com.nhb.service.TripService;
import javax.persistence.NoResultException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author T430s
 */
public class TripDescriptionValidator implements ConstraintValidator<TripDescription, String>{
    @Autowired
    private TripService tripService;

    @Override
    public void initialize(TripDescription constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            return tripService.checkTripDescription(value);
        } catch (NoResultException ex) {
            return false;
        }
    }
    
}
