package com.netcracker.studPract.converters;

import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.studPract.beans.SpecialityViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SpecialityEntityToView implements SpecialityConverter {

    @Autowired
    FacultiesService facultiesService;

    @Override
    public List<SpecialityViewModel> convert(List<SpecialityEntity> specialityEntity){

        List<SpecialityViewModel> specialityViewModels = new ArrayList<>();


        for (SpecialityEntity speciality : specialityEntity) {
            SpecialityViewModel specialityViewModel = new SpecialityViewModel();
            specialityViewModel.setNameFaculty(facultiesService.findFacultyById(speciality.getIdFaculty()).getFacultyName());
            specialityViewModel.setNameSpec(speciality.getNameSpec());
            specialityViewModel.setIdSpec(Integer.toString(speciality.getIdSpec()));
            specialityViewModels.add(specialityViewModel);
        }
        return specialityViewModels;
    }

    /*public SpecialityViewModel soloConverter(SpecialityEntity specialityEntity, FacultiesService facultiesService){


        return specialityViewModel;
    }*/

}
