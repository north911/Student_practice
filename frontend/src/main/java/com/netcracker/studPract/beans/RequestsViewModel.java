package com.netcracker.studPract.beans;

import java.sql.Date;

public class RequestsViewModel {

    private String idRequest;
    private String practicePeriod;
    private String idUser;
    private String companyName;
    private String dateFrom;
    private String dateTo;
    private String idSpec;
    private String idFaculty;

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
    }

    public String getPracticePeriod() {
        return practicePeriod;
    }

    public void setPracticePeriod(String practicePeriod) {
        this.practicePeriod = practicePeriod;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

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
}
