package com.tutorial.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@NoArgsConstructor
//@AllArgsConstructor
@Data
//@Builder
@Entity
@Table(name = "tb_Usuario")
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;

    public AuthUser() {
    }

    public AuthUser(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
