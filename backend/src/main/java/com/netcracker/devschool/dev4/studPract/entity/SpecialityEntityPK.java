package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SpecialityEntityPK implements Serializable {
    private int idSpec;
    private int idFaculty;

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

        SpecialityEntityPK that = (SpecialityEntityPK) o;

        if (idSpec != that.idSpec) return false;
        if (idFaculty != that.idFaculty) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSpec;
        result = 31 * result + idFaculty;
        return result;
    }
}
