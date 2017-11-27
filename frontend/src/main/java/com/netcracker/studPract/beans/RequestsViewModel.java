package com.netcracker.studPract.beans;

public class RequestsViewModel {

    private String companyName;
    private String idRequest;
    private String dateFrom;
    private String dateTo;
    private String nameSpec;
    private String nameFaculty;
    private String quantity;
    private String minAvg;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
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

    public String getNameSpec() {
        return nameSpec;
    }

    public void setNameSpec(String nameSpec) {
        this.nameSpec = nameSpec;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMinAvg() {
        return minAvg;
    }

    public void setMinAvg(String minAvg) {
        this.minAvg = minAvg;
    }
}
