package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RequestsEntityPK implements Serializable {
    private int idRequest;
    private int idUser;
    private int idSpec;
    private int idFaculty;

    @Column(name = "idRequest", nullable = false)
    @Id
    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    @Column(name = "idUser", nullable = false)
    @Id
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Column(name = "idSpec", nullable = false)
    @Id
    public int getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(int idSpec) {
        this.idSpec = idSpec;
    }

    @Column(name = "idFaculty", nullable = false)
    @Id
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

        RequestsEntityPK that = (RequestsEntityPK) o;

        if (idRequest != that.idRequest) return false;
        if (idUser != that.idUser) return false;
        if (idSpec != that.idSpec) return false;
        if (idFaculty != that.idFaculty) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRequest;
        result = 31 * result + idUser;
        result = 31 * result + idSpec;
        result = 31 * result + idFaculty;
        return result;
    }
}
