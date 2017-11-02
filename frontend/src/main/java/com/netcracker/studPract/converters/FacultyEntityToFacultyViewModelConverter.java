package com.netcracker.studPract.converters;

import com.netcracker.devschool.dev4.studPract.entity.FacultiesEntity;
import com.netcracker.studPract.beans.FacultyViewModel;
import org.springframework.core.convert.converter.Converter;

public class FacultyEntityToFacultyViewModelConverter implements Converter<FacultiesEntity, FacultyViewModel> {

    @Override
    public FacultyViewModel convert(FacultiesEntity facultiesEntity)
    {
        FacultyViewModel facultyViewModel = new FacultyViewModel();
        facultyViewModel.setFacName(facultiesEntity.getFacultyName());
        facultyViewModel.setIdFac(String.valueOf(facultiesEntity.getIdFaculty()));
        return facultyViewModel;
    }
}
