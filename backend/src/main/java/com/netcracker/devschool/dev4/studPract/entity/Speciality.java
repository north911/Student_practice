package com.netcracker.devschool.dev4.studPract.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "speciality")
public class Speciality {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long idSpeciality;

    @Column
    private long idFaculty;

    @Column
    private String NameSpec;

    @Column
    private long idGroup;

    public long getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(long idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public long getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(long idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getNameSpec() {
        return NameSpec;
    }

    public void setNameSpec(String nameSpec) {
        NameSpec = nameSpec;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "speciality")
    private Set<Students> students;

    public Set<Students> getStudents() {
        return students;
    }

    public void setUsers(Set<Students> students) {
        this.students = students;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "facultyId", nullable = false)
    private Faculties faculty;

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties facultie) {
        this.faculty = facultie;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "speciality")
    private Set<Requests> requests;

    public Set<Requests> getRequests() {
        return requests;
    }

    public void setRequests(Set<Requests> requests) {
        this.requests = requests;
    }
}
