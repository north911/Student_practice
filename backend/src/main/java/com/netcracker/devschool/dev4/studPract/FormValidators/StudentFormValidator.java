package com.netcracker.devschool.dev4.studPract.FormValidators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentFormValidator {


        @NotNull(message = "логин не может отсутствовать")
        @Size(min = 6, max = 10,message = "от 6 до 10 символов")
        private String login;

        @NotNull(message = "пароль не может отсутствовать")
        @Size(min = 6, max = 15, message = "от 6 до 15 символов")
        private String password;

        @NotNull(message = "Имя не может отсутствовать")
        @Size(min = 2, max = 15, message = "от 2 до 15 символов")
        private String firstName;

        @NotNull(message = "Имя не может отсутствовать")
        @Size(min = 2, max = 15, message = "от 2 до 15 символов")
        private String lastName;


        @NotNull(message = "средний балл не может отсутствовать")
        private String avgB;

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

    public String getAvgB() {
        return avgB;
    }

    public void setAvgB(String avgB) {
        this.avgB = avgB;
    }
}
