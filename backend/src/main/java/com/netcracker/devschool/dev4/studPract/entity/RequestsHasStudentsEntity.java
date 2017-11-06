package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.*;

@Entity
@Table(name = "requests_has_students", schema = "stpractice")
public class RequestsHasStudentsEntity {
    @Id
    private int requestsIdRequest;


    private int studentsIdUser;

    public int getRequestsIdRequest() {
        return requestsIdRequest;
    }

    public void setRequestsIdRequest(int requestsIdRequest) {
        this.requestsIdRequest = requestsIdRequest;
    }


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

        RequestsHasStudentsEntity that = (RequestsHasStudentsEntity) o;

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
