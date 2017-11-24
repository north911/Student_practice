package com.netcracker.devschool.dev4.studPract.entity;

import javax.persistence.*;


@Entity
@Table(name = "user_roles", schema = "stpractice")
public class UserRolesEntity {

    @Id
    private String username;

    private String role;

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getUserrole() {
        return role;
    }

    public void setUserrole(String userrole) {
        this.role = userrole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRolesEntity that = (UserRolesEntity) o;

        if (!username.equals(that.username)) return false;
            return role.equals(that.role);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
