package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import com.netcracker.devschool.dev4.studPract.service.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public RequestsEntity addRequest(@RequestParam(value = "company", required = false) String compName,
                                     @RequestParam(value = "dateFrom", required = false) String fromDate,
                                     @RequestParam(value = "dateTo", required = false) String toDate,
                                     @RequestParam(value = "idFac", required = false) String idFac,
                                     @RequestParam(value = "idSpec", required = false) String idSpec,
                                     @RequestParam(value = "quantity", required = false) String quantity,
                                     @RequestParam(value = "minAvg", required = false) String minAvg){

        RequestsEntity requestsEntity = new RequestsEntity();

        try{
            DateFormat format = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);
            try {
                Date start = format.parse(fromDate);
                requestsEntity.setDateFrom(start);
                Date end = format.parse(toDate);
                requestsEntity.setDateTo(end);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            requestsEntity.setCompanyName(compName);
            requestsEntity.setIdFaculty(Integer.parseInt(idFac));
            requestsEntity.setIdSpec(Integer.parseInt(idSpec));
            requestsEntity.setQuantity(Integer.parseInt(quantity));
            requestsEntity.setMinAvg(Double.parseDouble(minAvg));
            requestsService.save(requestsEntity);}
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return requestsEntity;
    }

    @RequestMapping("/removeRequest/{id}")
    public String removeRequest(@PathVariable("id") int id){
        requestsService.deleteRequestById(id);

        return "redirect:/admin";
    }
}
