/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.formatter;

import com.nhb.pojo.Route;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author VIP
 */
public class RouteFormatter implements Formatter<Route>{

    @Override
    public String print(Route t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Route parse(String string, Locale locale) throws ParseException {
        Route r = new Route();
        r.setId(Integer.parseInt(string));
        
        return r;
    }
    
}
