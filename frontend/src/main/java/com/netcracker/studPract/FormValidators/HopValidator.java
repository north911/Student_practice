package com.netcracker.studPract.FormValidators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HopValidator {

    @NotNull(message = "логин не может отсутствовать")
    @Size(min = 3, max = 20,message = "от 3 до 20 символов")
    private String hopLogin;

    @NotNull(message = "пароль не может отсутствовать")
    @Size(min = 6, max = 20, message = "от 6 до 20 символов")
    private String hopPassword;

    @NotNull(message = "Имя не может отсутствовать")
    @Size(min = 2, max = 45, message = "от 2 до 15 символов")
    private String hopFirstName;

    @NotNull(message = "Имя не может отсутствовать")
    @Size(min = 2, max = 45, message = "от 2 до 15 символов")
    private String hopLastName;

    public String getHopLogin() {
        return hopLogin;
    }

    public void setHopLogin(String hopLogin) {
        this.hopLogin = hopLogin;
    }

    public String getHopPassword() {
        return hopPassword;
    }

    public void setHopPassword(String hopPassword) {
        this.hopPassword = hopPassword;
    }

    public String getHopFirstName() {
        return hopFirstName;
    }

    public void setHopFirstName(String hopFirstName) {
        this.hopFirstName = hopFirstName;
    }

    public String getHopLastName() {
        return hopLastName;
    }

    public void setHopLastName(String hopLastName) {
        this.hopLastName = hopLastName;
    }
}
