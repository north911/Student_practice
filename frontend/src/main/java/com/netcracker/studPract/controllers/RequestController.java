package com.netcracker.studPract.controllers;


import com.netcracker.devschool.dev4.studPract.FormValidators.RequestValidator;
import com.netcracker.devschool.dev4.studPract.entity.AssigmentsEntity;
import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import com.netcracker.devschool.dev4.studPract.service.AssigmentsService;
import com.netcracker.devschool.dev4.studPract.service.RequestsService;
import com.netcracker.devschool.dev4.studPract.service.StudentsService;
import com.netcracker.studPract.beans.StudentViewModel;
import com.netcracker.studPract.converters.StudentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class RequestController {

    @Autowired
    RequestsService requestsService;

    @Autowired
    StudentsService studentsService;

    @Autowired
    StudentConverter studentConverter;

    @Autowired
    AssigmentsService assigmentsService;

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
            requestsEntity.setIsBudget(Byte.parseByte(requestValidator.getIsBudget()));
            requestsEntity.setIdHead(Integer.parseInt(requestValidator.getIdHead()));
            requestsService.save(requestsEntity);
            return requestsEntity;}

    }

    @RequestMapping("/removeRequest/{id}")
    public String removeRequest(@PathVariable("id") int id){
        requestsService.deleteRequestById(id);

        return "redirect:/admin";
    }
    @RequestMapping("/findForRequest/{idH}/{idR}")
    public ModelAndView assignRequest(@PathVariable("idH") int idH,
                                      @PathVariable("idR") int idR){

        ModelAndView model = new ModelAndView("head");
        model.addObject("listStudents" , new ArrayList<StudentViewModel>(studentConverter.convert(studentsService.findForRequest(
                requestsService.findRequestById(idR).getMinAvg(),
                requestsService.findRequestById(idR).getIdSpec(),
                requestsService.findRequestById(idR).getDateFrom(),
                requestsService.findRequestById(idR).getDateTo(),
                requestsService.findRequestById(idR).getIsBudget()))));
        model.addObject("requestId", idR);
        model.addObject("headId", idH);
        return model ;
    }

    @RequestMapping(value = "findForRequest/{idh}/assignRequest/{ida}", method = RequestMethod.POST)
    @ResponseBody
    public String assignRequest(@PathVariable("ida") int ida,
                                @PathVariable("idh") int idh,
            @RequestParam(value = "id[]",required = false)List<String> ids){

        AssigmentsEntity assigmentsEntity = new AssigmentsEntity();
        for (String s : ids) {
            assigmentsEntity.setIdUser(Integer.parseInt(s));
            assigmentsEntity.setIdRequest(ida);
            assigmentsEntity.setIdHead(idh);
            assigmentsService.saveAssigment(assigmentsEntity);
        }
     return "redirect:/head";}

}
