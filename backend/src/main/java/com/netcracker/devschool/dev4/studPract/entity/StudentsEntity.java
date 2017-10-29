package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.*;

@Entity
@Table(name = "students", schema = "stpractice", catalog = "")
@IdClass(StudentsEntityPK.class)
public class StudentsEntity {
    private int idUser;
    private int avgBall;
    private byte isBudget;
    private int idGroup;
    private int idSpec;
    private RequestsHasStudentsEntity requestsHasStudentsByIdUser;

    @Id
    @Column(name = "idUser", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "avg_ball", nullable = false)
    public int getAvgBall() {
        return avgBall;
    }

    public void setAvgBall(int avgBall) {
        this.avgBall = avgBall;
    }

    @Basic
    @Column(name = "isBudget", nullable = false)
    public byte getIsBudget() {
        return isBudget;
    }

    public void setIsBudget(byte isBudget) {
        this.isBudget = isBudget;
    }

    @Basic
    @Column(name = "idGroup", nullable = false)
    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Id
    @Column(name = "idSpec", nullable = false)
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

        StudentsEntity that = (StudentsEntity) o;

        if (idUser != that.idUser) return false;
        if (avgBall != that.avgBall) return false;
        if (isBudget != that.isBudget) return false;
        if (idGroup != that.idGroup) return false;
        if (idSpec != that.idSpec) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + avgBall;
        result = 31 * result + (int) isBudget;
        result = 31 * result + idGroup;
        result = 31 * result + idSpec;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "Students_idUser", nullable = false)
    public RequestsHasStudentsEntity getRequestsHasStudentsByIdUser() {
        return requestsHasStudentsByIdUser;
    }

    public void setRequestsHasStudentsByIdUser(RequestsHasStudentsEntity requestsHasStudentsByIdUser) {
        this.requestsHasStudentsByIdUser = requestsHasStudentsByIdUser;
    }
}
