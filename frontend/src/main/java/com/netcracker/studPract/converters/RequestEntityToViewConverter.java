package com.netcracker.studPract.converters;

import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import com.netcracker.devschool.dev4.studPract.service.AssigmentsService;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.devschool.dev4.studPract.service.SpecialityService;
import com.netcracker.studPract.beans.RequestsViewModel;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class RequestEntityToViewConverter implements RequestConverter {

    @Autowired
    FacultiesService facultiesService;

    @Autowired
    SpecialityService specialityService;

    @Autowired
    AssigmentsService assigmentsService;

    @Autowired
    ApplicationContext applicationContext;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    @Override
    public List<RequestsViewModel> convert(List<RequestsEntity> requestsEntities) {

        List<RequestsViewModel> requestsViewModels = new ArrayList<>();

        for (RequestsEntity requestsEntity : requestsEntities) {
            RequestsViewModel requestsViewModel = (RequestsViewModel)applicationContext.getBean("requestsViewModel");
            requestsViewModel.setCompanyName(requestsEntity.getCompanyName());
            requestsViewModel.setDateFrom(simpleDateFormat.format(requestsEntity.getDateFrom()));
            requestsViewModel.setDateTo(simpleDateFormat.format(requestsEntity.getDateTo()));
            requestsViewModel.setIdRequest(Integer.toString(requestsEntity.getIdRequest()));
            requestsViewModel.setMinAvg(Double.toString(requestsEntity.getMinAvg()));
            requestsViewModel.setQuantity(Integer.toString(requestsEntity.getQuantity()));
            requestsViewModel.setNameSpec(specialityService.findById(requestsEntity.getIdSpec()).getNameSpec());
            requestsViewModel.setNameFaculty(facultiesService.findFacultyById(requestsEntity.getIdFaculty()).getFacultyName());
            requestsViewModel.setAvailableQuantity(Integer.toString(requestsEntity.getQuantity() - assigmentsService.findByIdRequest(requestsEntity.getIdRequest()).size()));
            requestsViewModels.add(requestsViewModel);
        }

        return requestsViewModels;
    }

}
