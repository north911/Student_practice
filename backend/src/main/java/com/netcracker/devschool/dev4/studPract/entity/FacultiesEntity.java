package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.*;

@Entity
@Table(name = "faculties", schema = "stpractice")
public class FacultiesEntity {

    private int idFaculty;
    private String facultyName;

    @Id
    @Column(name = "idFaculty", nullable = false)
    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    @Basic
    @Column(name = "FacultyName", nullable = false, length = 45)
    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacultiesEntity that = (FacultiesEntity) o;

        if (idFaculty != that.idFaculty) return false;
        if (facultyName != null ? !facultyName.equals(that.facultyName) : that.facultyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFaculty;
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        return result;
    }
}
