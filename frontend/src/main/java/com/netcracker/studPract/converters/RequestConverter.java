package com.netcracker.studPract.converters;

import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.devschool.dev4.studPract.service.SpecialityService;
import com.netcracker.studPract.beans.RequestsViewModel;

import java.util.List;

public interface RequestConverter {

    List<RequestsViewModel> convert(List<RequestsEntity> requestsEntities);
}
