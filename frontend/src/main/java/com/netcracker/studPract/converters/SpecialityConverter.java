package com.netcracker.studPract.converters;

import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.studPract.beans.SpecialityViewModel;

import java.util.List;

public interface SpecialityConverter {
    List<SpecialityViewModel> convert(List<SpecialityEntity> specialityEntiry);
}
