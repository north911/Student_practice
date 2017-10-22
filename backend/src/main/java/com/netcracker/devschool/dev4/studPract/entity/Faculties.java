package com.netcracker.devschool.dev4.studPract.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "faculty")
public class Faculties {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long idFaculty;

    @Column
    private String facultyName;

    public long getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(long idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "faculty")
    private Set<Speciality> speciality;

    public Set<Speciality> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Set<Speciality> speciality) {
        this.speciality = speciality;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "faculty")
    private Set<Requests> requests;

    public Set<Requests> getRequests() {
        return requests;
    }

    public void setRequests(Set<Requests> requests) {
        this.requests = requests;
    }

}
