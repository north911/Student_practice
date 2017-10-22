package com.netcracker.devschool.dev4.studPract.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long idStudent;

    @Column
    private double avgBall;

    @Column
    private boolean isBudget;

    @Column
    private long idUser;

    @Column
    private long idGroup;

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public double getAvgBall() {
        return avgBall;
    }

    public void setAvgBall(double avgBall) {
        this.avgBall = avgBall;
    }

    public boolean isBudget() {
        return isBudget;
    }

    public void setBudget(boolean budget) {
        isBudget = budget;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students student = (Students) o;
        return idStudent != 0 ? idStudent == student.idStudent : student.idStudent == 0;
    }

    @OneToOne(optional = false, mappedBy="student")
    public Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "group_id", nullable = false)
    private Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "students")
    private Set<Requests> requests;

    public Set<Requests> getRequests() {
        return requests;
    }

    public void setRequests(Set<Requests> requests) {
        this.requests = requests;
    }
}
