package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.FormValidators.RequestValidator;
import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import com.netcracker.devschool.dev4.studPract.service.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class RequestController {

    @Autowired
    RequestsService requestsService;

    @RequestMapping(value = "/createRequest", method = RequestMethod.POST)
    @ResponseBody
    public Object addRequest(@Valid @ModelAttribute RequestValidator requestValidator, BindingResult result){

        if (result.hasErrors()) {
            return result.getAllErrors();
        } else{
        RequestsEntity requestsEntity = new RequestsEntity();
        DateFormat format = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);
            try {
                Date start = format.parse(requestValidator.getDateFrom());
                requestsEntity.setDateFrom(start);
                Date end = format.parse(requestValidator.getDateTo());
                requestsEntity.setDateTo(end);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            requestsEntity.setCompanyName(requestValidator.getCompanyName());
            requestsEntity.setIdFaculty(Integer.parseInt(requestValidator.getIdFaculty()));
            requestsEntity.setIdSpec(Integer.parseInt(requestValidator.getIdSpec()));
            requestsEntity.setQuantity(requestValidator.getQuantity());
            requestsEntity.setMinAvg(requestValidator.getMinAvgBall());
            requestsService.save(requestsEntity);
            return requestsEntity;}

    }

    @RequestMapping("/removeRequest/{id}")
    public String removeRequest(@PathVariable("id") int id){
        requestsService.deleteRequestById(id);

        return "redirect:/admin";
    }
}
