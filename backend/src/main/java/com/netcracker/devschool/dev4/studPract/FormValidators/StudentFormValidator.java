package com.netcracker.devschool.dev4.studPract.FormValidators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentFormValidator {


        @NotNull(message = "логин не может отсутствовать")
        @Size(min = 3, max = 15,message = "от 3 до 10 символов")
        private String login;

        @NotNull(message = "пароль не может отсутствовать")
        @Size(min = 6, max = 45, message = "от 6 до 45 символов")
        private String password;

        @NotNull(message = "Имя не может отсутствовать")
        @Size(min = 2, max = 15, message = "от 2 до 15 символов")
        private String firstName;

        @NotNull(message = "Имя не может отсутствовать")
        @Size(min = 2, max = 15, message = "от 2 до 15 символов")
        private String lastName;

        @NotNull(message = "не может отсутствовать")
        private String idSpec;

        @NotNull(message = "не может отсутствовать")
        private String idFaculty;

        @NotNull(message = "средний балл не может отсутствовать")
        private String avgBall;

        @NotNull(message = "номер группы не может отсутствовать")
        @Size(min = 6, max = 6, message = "6 символов")
        private String idGroup;

        @NotNull(message = "не может отсутствовать")
        private String isBudget;

    public String getIsBudget() {
        return isBudget;
    }

    public void setIsBudget(String isBudget) {
        this.isBudget = isBudget;
    }

    public String getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(String idSpec) {
        this.idSpec = idSpec;
    }

    public String getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvgBall() {
        return avgBall;
    }

    public void setAvgBall(String avgBall) {
        this.avgBall = avgBall;
    }
}
