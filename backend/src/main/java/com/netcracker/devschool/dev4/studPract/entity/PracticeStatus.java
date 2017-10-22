package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "practiceStatus")
public class PracticeStatus {

    @Column
    private long idStudent;

    @Column
    private long idRequest;

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public long getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(long idRequest) {
        this.idRequest = idRequest;
    }
}
