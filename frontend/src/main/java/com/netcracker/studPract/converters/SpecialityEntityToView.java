package com.netcracker.studPract.converters;

import com.netcracker.devschool.dev4.studPract.entity.SpecialityEntity;
import com.netcracker.devschool.dev4.studPract.service.FacultiesService;
import com.netcracker.studPract.beans.SpecialityViewModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SpecialityEntityToView implements SpecialityConverter {



    @Override
    public List<SpecialityViewModel> convert(List<SpecialityEntity> specialityEntity, FacultiesService facultiesService){

        List<SpecialityViewModel> specialityViewModel = new ArrayList<>();
        SpecialityEntityToView specialityEntityToView = new SpecialityEntityToView();

        for (SpecialityEntity speciality : specialityEntity) {
            specialityViewModel.add(specialityEntityToView.soloConverter(speciality,facultiesService));
        }
        return specialityViewModel;
    }

    public SpecialityViewModel soloConverter(SpecialityEntity specialityEntity, FacultiesService facultiesService){
        SpecialityViewModel specialityViewModel = new SpecialityViewModel();
        specialityViewModel.setNameFaculty(facultiesService.findAllFaculties().stream().filter(FacultiesEntity -> FacultiesEntity.getIdFaculty()== specialityEntity.getIdFaculty()).findFirst().get().getFacultyName());
        specialityViewModel.setNameSpec(specialityEntity.getNameSpec());
        specialityViewModel.setIdSpec(Integer.toString(specialityEntity.getIdSpec()));
        return specialityViewModel;
    }

}
