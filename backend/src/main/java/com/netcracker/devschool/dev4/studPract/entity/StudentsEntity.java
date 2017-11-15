package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.*;

@Entity
@Table(name = "students", schema = "stpractice")
public class StudentsEntity {

    @Id
    private int idUser;

    private int avgBall;

    private byte isBudget;

    private int idGroup;

    private int idSpec;


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    public int getAvgBall() {
        return avgBall;
    }

    public void setAvgBall(int avgBall) {
        this.avgBall = avgBall;
    }


    public byte getIsBudget() {
        return isBudget;
    }

    public void setIsBudget(byte isBudget) {
        this.isBudget = isBudget;
    }


    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }


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

}
