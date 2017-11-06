package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.*;

@Entity
@Table(name = "speciality", schema = "stpractice")
public class SpecialityEntity {

    @Id
    private int idSpec;

    private String nameSpec;

    private int idFaculty;


    public int getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(int idSpec) {
        this.idSpec = idSpec;
    }



    public String getNameSpec() {
        return nameSpec;
    }

    public void setNameSpec(String nameSpec) {
        this.nameSpec = nameSpec;
    }

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

}
