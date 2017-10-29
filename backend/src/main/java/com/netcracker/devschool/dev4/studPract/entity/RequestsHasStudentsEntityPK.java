package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RequestsHasStudentsEntityPK implements Serializable {
    private int requestsIdRequest;
    private int studentsIdUser;

    @Column(name = "Requests_idRequest", nullable = false)
    @Id
    public int getRequestsIdRequest() {
        return requestsIdRequest;
    }

    public void setRequestsIdRequest(int requestsIdRequest) {
        this.requestsIdRequest = requestsIdRequest;
    }

    @Column(name = "Students_idUser", nullable = false)
    @Id
    public int getStudentsIdUser() {
        return studentsIdUser;
    }

    public void setStudentsIdUser(int studentsIdUser) {
        this.studentsIdUser = studentsIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestsHasStudentsEntityPK that = (RequestsHasStudentsEntityPK) o;

        if (requestsIdRequest != that.requestsIdRequest) return false;
        if (studentsIdUser != that.studentsIdUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestsIdRequest;
        result = 31 * result + studentsIdUser;
        return result;
    }
}
