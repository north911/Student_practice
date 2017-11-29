/*
 This software is the confidential information and copyrighted work of
 NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 is only distributed under the terms of a separate license agreement
 with NetCracker.
 Use of the software is governed by the terms of the license agreement.
 Any use of this software not in accordance with the license agreement
 is expressly prohibited by law, and may result in severe civil
 and criminal penalties. 
 
 Copyright (c) 1995-2017 NetCracker Technology Corp.
 
 All Rights Reserved.
 
*/
/*
 * Copyright 1995-2017 by NetCracker Technology Corp.,
 * University Office Park III
 * 95 Sawyer Road
 * Waltham, MA 02453
 * United States of America
 * All rights reserved.
 */
package com.netcracker.studPract.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class TestController {



   /* @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "loginpage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String pass){
        String result;
        switch (email){
            case "admin@gmail.com":
                result = "admin";
            break;
            case "head@gmail.com":
                result = "head";
                break;
                default:
                    result= "profile";
        }
        return result;

    }*/
   @RequestMapping(value = "/logout", method = RequestMethod.GET)
   public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth != null) {
           new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
   }


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String goToProfile() {
        return "profile";
    }

    @RequestMapping(value = "/head", method = RequestMethod.GET)
    public String goToHead() {
        return "head";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            String role = auth.getAuthorities().toString();


            String targetUrl = "";
            if (role.contains("STUDENT")) {
                targetUrl = "/profile";
            } else if (role.contains("HEAD")) {
                targetUrl = "/head";
            } else if (role.contains("ADMIN")) {
                targetUrl = "/admin";
            }

            return new ModelAndView("redirect:" + targetUrl);

        }

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }



}

