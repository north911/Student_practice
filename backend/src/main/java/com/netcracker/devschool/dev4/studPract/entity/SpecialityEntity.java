package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.*;

@Entity
@Table(name = "speciality", schema = "stpractice", catalog = "")
@IdClass(SpecialityEntityPK.class)
public class SpecialityEntity {
    private int idSpec;
    private String nameSpec;
    private int idFaculty;
    private RequestsEntity requestsByIdSpec;
    private FacultiesEntity facultiesByIdFaculty;

    @Id
    @Column(name = "idSpec", nullable = false)
    public int getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(int idSpec) {
        this.idSpec = idSpec;
    }

    @Basic
    @Column(name = "NameSpec", nullable = false, length = 45)
    public String getNameSpec() {
        return nameSpec;
    }

    public void setNameSpec(String nameSpec) {
        this.nameSpec = nameSpec;
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

        SpecialityEntity that = (SpecialityEntity) o;

        if (idSpec != that.idSpec) return false;
        if (idFaculty != that.idFaculty) return false;
        if (nameSpec != null ? !nameSpec.equals(that.nameSpec) : that.nameSpec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSpec;
        result = 31 * result + (nameSpec != null ? nameSpec.hashCode() : 0);
        result = 31 * result + idFaculty;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idSpec", referencedColumnName = "idSpec", nullable = false)
    public RequestsEntity getRequestsByIdSpec() {
        return requestsByIdSpec;
    }

    public void setRequestsByIdSpec(RequestsEntity requestsByIdSpec) {
        this.requestsByIdSpec = requestsByIdSpec;
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
