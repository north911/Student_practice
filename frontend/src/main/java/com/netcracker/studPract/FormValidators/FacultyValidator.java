package com.netcracker.studPract.FormValidators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FacultyValidator {

    @NotNull(message = "название не может отсутствовать")
    @Size(min = 2, max = 10,message = "от 2 до 10 символов")
    private String facName;

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }
}
