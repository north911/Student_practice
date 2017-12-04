package com.netcracker.devschool.dev4.studPract.FormValidators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SpecialityValidator {

    @NotNull(message = "название не может отсутствовать")
    @Size(min = 2, max = 10,message = "от 2 до 10 символов")
    private String specName;
}
