package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class StudentsEntityPK implements Serializable {
    private int idUser;
    private int idSpec;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEntityPK that = (StudentsEntityPK) o;

        if (idUser != that.idUser) return false;
        if (idSpec != that.idSpec) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + idSpec;
        return result;
    }
}
