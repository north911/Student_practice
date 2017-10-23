package com.netcracker.devschool.dev4.studPract.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "requests")
public class Requests {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    //@Column(name = "id", length = 6, nullable = false)
    private long idRequest;

    @Column
    private long idUser;

    @Column
    private String companyName;

    @Column
    private long idSpec;

    @Column
    private long idFaculty;

    public long getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(long idRequest) {
        this.idRequest = idRequest;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(long idSpec) {
        this.idSpec = idSpec;
    }

    public long getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(long idFaculty) {
        this.idFaculty = idFaculty;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "faculty_id1", nullable = false)
    private Faculties faculty;

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id1", nullable = false)
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @ManyToMany
    @JoinTable(name="requests_students",
            joinColumns = @JoinColumn(name="request_id", referencedColumnName="idRequest"),
            inverseJoinColumns = @JoinColumn(name="student_id", referencedColumnName="idStudent")
    )
    private Set<Students> students;

    public Set<Students > getStudents() {
        return students;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }
}
