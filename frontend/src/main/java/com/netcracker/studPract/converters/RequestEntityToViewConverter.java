package com.netcracker.studPract.converters;

import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.devschool.dev4.studPract.service.SpecialityService;
import com.netcracker.studPract.beans.RequestsViewModel;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestEntityToViewConverter implements RequestConverter {

    @Autowired
    FacultiesService facultiesService;

    @Autowired
    SpecialityService specialityService;


    @Override
    public List<RequestsViewModel> convert(List<RequestsEntity> requestsEntities) {

        List<RequestsViewModel> requestsViewModels = new ArrayList<>();
        //RequestEntityToViewConverter requestEntityToViewConverter = new RequestEntityToViewConverter();

        for (RequestsEntity requestsEntity : requestsEntities) {
            RequestsViewModel requestsViewModel = new RequestsViewModel();
            requestsViewModel.setCompanyName(requestsEntity.getCompanyName());
            requestsViewModel.setDateFrom(requestsEntity.getDateFrom().toString());
            requestsViewModel.setDateTo(requestsEntity.getDateFrom().toString());
            requestsViewModel.setIdRequest(Integer.toString(requestsEntity.getIdRequest()));
            requestsViewModel.setMinAvg(Double.toString(requestsEntity.getMinAvg()));
            requestsViewModel.setQuantity(Integer.toString(requestsEntity.getQuantity()));
            requestsViewModel.setNameSpec(specialityService.findById(requestsEntity.getIdSpec()).getNameSpec());
            requestsViewModel.setNameFaculty(facultiesService.findFacultyById(requestsEntity.getIdFaculty()).getFacultyName());
            requestsViewModels.add(requestsViewModel);
        }

        return requestsViewModels;
    }

  /*  public RequestsViewModel soloConvert(RequestsEntity requestsEntity, FacultiesService facultiesService, SpecialityService specialityService){

        //RequestsViewModel requestsViewModel = new RequestsViewModel();
        *//*requestsViewModel.setCompanyName(requestsEntity.getCompanyName());
        requestsViewModel.setDateFrom(requestsEntity.getDateFrom().toString());
        requestsViewModel.setDateTo(requestsEntity.getDateFrom().toString());
        requestsViewModel.setIdRequest(Integer.toString(requestsEntity.getIdRequest()));
        requestsViewModel.setMinAvg(Double.toString(requestsEntity.getMinAvg()));
        requestsViewModel.setQuantity(Integer.toString(requestsEntity.getQuantity()));
        requestsViewModel.setNameSpec(specialityService.findById(requestsEntity.getIdSpec()).getNameSpec());
        requestsViewModel.setNameFaculty(facultiesService.findFacultyById(requestsEntity.getIdFaculty()).getFacultyName());

        return requestsViewModel;*//*
    }*/
}
