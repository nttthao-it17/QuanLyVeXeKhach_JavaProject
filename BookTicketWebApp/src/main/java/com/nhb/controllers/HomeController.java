/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.controllers;

import com.nhb.pojo.Cart;
import com.nhb.service.RouteService;
import com.nhb.service.TripService;
import com.nhb.validator.WebAppValidator;
import java.math.BigDecimal;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VIP
 */
@Controller
public class HomeController {
    @Autowired
    private RouteService routeService;
    @Autowired
    private TripService tripService;
    @Autowired
    @Qualifier("myapp")
    private WebAppValidator tripValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(tripValidator);
    }
    
    @ModelAttribute
    public void addAttributes(HttpSession session, Model model) {
        int count = 0;
        
        if (session.getAttribute("cart") != null) {
            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("cart");
            for (Cart c: carts.values())
                count += c.getNum();
        }
        
        model.addAttribute("cartCount", count);
    }
    
    //PAGE HOME
    @RequestMapping(value = "/")
    public ModelAndView index(@RequestParam(value = "route_id", defaultValue = "") String routeId,
            @RequestParam(value = "kw", defaultValue = "") String kw) {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("routes", routeService.getRoutes());
        if (routeId.isEmpty())
            view.addObject("trips", tripService.getTrips(kw));
        else
            view.addObject("trips", 
                    routeService.getTripByRoute(Integer.parseInt(routeId)));
        
        return view;
    }
    
//    PAGE CART DETAIL
    @GetMapping(value = "/cart")
    public String cart(Model model, HttpSession session) {
        if (session.getAttribute("cart") != null) {
            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("cart");

            BigDecimal sum = new BigDecimal(0);
            
            for (Cart c: carts.values())
                sum = sum.add(c.getTrip()
                               .getPrice()
                               .multiply(new BigDecimal(c.getNum())));

            model.addAttribute("carts", carts.values());
            model.addAttribute("sum", sum);
        }

        return "cart";
    }
    
    @RequestMapping(value = "/contact")
    public String feedbackView(Model model,
            @RequestParam(name = "contact", required = false) String contact) {
        model.addAttribute("contact", "");

        return "contact";
    }
}
    

