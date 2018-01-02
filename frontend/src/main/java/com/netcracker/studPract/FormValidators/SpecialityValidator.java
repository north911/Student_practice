package com.netcracker.studPract.FormValidators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SpecialityValidator {

    @NotNull(message = "название не может отсутствовать")
    @Size(min = 2, max = 10,message = "от 2 до 10 символов")
    private String specName;

    @NotNull
    private String facultyId;

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

}
