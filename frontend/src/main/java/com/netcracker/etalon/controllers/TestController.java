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
package com.netcracker.etalon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestController {

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
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

    }

             @RequestMapping(value = "/admin", method = RequestMethod.GET)
     public String goToAdmin() {
               return "admin";
           }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String goToProfile() {
        return "profile";
    }
    @RequestMapping(value = "/head", method = RequestMethod.GET)
    public String goToHead() {
        return "head";
    }

}

