package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "requests", schema = "stpractice")
public class RequestsEntity {
    @Id
    private int idRequest;

    private String companyName;

    private java.util.Date dateFrom;

    private java.util.Date dateTo;

    private int idSpec;

    private int idFaculty;

    private int quantity;

    private double minAvg;

    private int idHead;

    private byte isBudget;

    public byte getIsBudget() {
        return isBudget;
    }

    public void setIsBudget(byte isBudget) {
        this.isBudget = isBudget;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public int getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(int idSpec) {
        this.idSpec = idSpec;
    }

    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMinAvg() {
        return minAvg;
    }

    public void setMinAvg(double minAvg) {
        this.minAvg = minAvg;
    }

    public int getIdHead() {
        return idHead;
    }

    public void setIdHead(int idHead) {
        this.idHead = idHead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestsEntity that = (RequestsEntity) o;

        if (idRequest != that.idRequest) return false;
        if (idSpec != that.idSpec) return false;
        if (idFaculty != that.idFaculty) return false;
        if (quantity != that.quantity) return false;
        if (Double.compare(that.minAvg, minAvg) != 0) return false;
        if (idHead != that.idHead) return false;
        if (!companyName.equals(that.companyName)) return false;
        if (!dateFrom.equals(that.dateFrom)) return false;
        return dateTo.equals(that.dateTo);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idRequest;
        result = 31 * result + companyName.hashCode();
        result = 31 * result + dateFrom.hashCode();
        result = 31 * result + dateTo.hashCode();
        result = 31 * result + idSpec;
        result = 31 * result + idFaculty;
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(minAvg);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + idHead;
        return result;
    }
}
