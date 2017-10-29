package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "requests", schema = "stpractice", catalog = "")
@IdClass(RequestsEntityPK.class)
public class RequestsEntity {
    private int idRequest;
    private Date practicePeriod;
    private int idUser;
    private String companyName;
    private Date dateFrom;
    private Date dateTo;
    private int idSpec;
    private int idFaculty;
    private FacultiesEntity facultiesByIdFaculty;

    @Id
    @Column(name = "idRequest", nullable = false)
    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    @Basic
    @Column(name = "practice_period", nullable = false)
    public Date getPracticePeriod() {
        return practicePeriod;
    }

    public void setPracticePeriod(Date practicePeriod) {
        this.practicePeriod = practicePeriod;
    }

    @Id
    @Column(name = "idUser", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "CompanyName", nullable = false, length = 45)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "dateFrom", nullable = false)
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Basic
    @Column(name = "dateTo", nullable = false)
    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Id
    @Column(name = "idSpec", nullable = false)
    public int getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(int idSpec) {
        this.idSpec = idSpec;
    }

    @Id
    @Column(name = "idFaculty", nullable = false)
    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestsEntity that = (RequestsEntity) o;

        if (idRequest != that.idRequest) return false;
        if (idUser != that.idUser) return false;
        if (idSpec != that.idSpec) return false;
        if (idFaculty != that.idFaculty) return false;
        if (practicePeriod != null ? !practicePeriod.equals(that.practicePeriod) : that.practicePeriod != null)
            return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(that.dateTo) : that.dateTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRequest;
        result = 31 * result + (practicePeriod != null ? practicePeriod.hashCode() : 0);
        result = 31 * result + idUser;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + idSpec;
        result = 31 * result + idFaculty;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idFaculty", referencedColumnName = "idFaculty", nullable = false)
    public FacultiesEntity getFacultiesByIdFaculty() {
        return facultiesByIdFaculty;
    }

    public void setFacultiesByIdFaculty(FacultiesEntity facultiesByIdFaculty) {
        this.facultiesByIdFaculty = facultiesByIdFaculty;
    }
}
