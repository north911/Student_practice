package com.netcracker.studPract.FormValidators;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequestValidator {

    @NotNull(message = "название не может отсутствовать")
    @Size(min = 2, max = 30,message = "от 2 до 30 символов")
    private String companyName;

    @NotNull(message = "дата не может отсутствовать")
    private String dateFrom;

    @NotNull(message = "дата не может отсутствовать")
    private String dateTo;

    @NotNull(message = "не может отсутствовать")
    private String idFaculty;

    @NotNull(message = "не может отсутствовать")
    private String idSpec;

    @NotNull(message = "не может отсутствовать")
    @Min(1) @Max(15)
    private int quantity;

    @NotNull(message = "не может отсутствовать")
    private String idHead;

    @NotNull
    private String isBudget;

    @NotNull(message = "не может отсутствовать")
    @Min(4) @Max(10)
    private int minAvgBall;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(String idSpec) {
        this.idSpec = idSpec;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMinAvgBall() {
        return minAvgBall;
    }

    public void setMinAvgBall(int minAvgBall) {
        this.minAvgBall = minAvgBall;
    }

    public String getIdHead() {
        return idHead;
    }

    public void setIdHead(String idHead) {
        this.idHead = idHead;
    }

    public String getIsBudget() {
        return isBudget;
    }

    public void setIsBudget(String isBudget) {
        this.isBudget = isBudget;
    }
}
