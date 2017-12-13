package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.*;

@Entity
@Table(name = "assigment", schema = "stpractice")
public class AssigmentsEntity {

    private int idRequest;


    private int idUser;

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssigmentsEntity that = (AssigmentsEntity) o;

        if (idRequest != that.idRequest) return false;
        return idUser == that.idUser;
    }

    @Override
    public int hashCode() {
        int result = idRequest;
        result = 31 * result + idUser;
        return result;
    }
}
