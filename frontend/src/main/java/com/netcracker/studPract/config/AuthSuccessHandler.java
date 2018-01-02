package com.netcracker.studPract.config;

import com.netcracker.devschool.dev4.studPract.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    UsersService usersService;

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        // Get the role of logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();


        String targetUrl = "";
        if (role.contains("STUDENT")) {
            targetUrl = "/profile/" + usersService.findByUserLogin(auth.getName()).getIdUsers();
        } else if (role.contains("HEAD")) {
            targetUrl = "/head/" + usersService.findByUserLogin(auth.getName()).getIdUsers();
        } else if (role.contains("ADMIN")) {
            targetUrl = "/admin";
        }
        return targetUrl;
    }
}