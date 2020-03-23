package com.squad2.CentralDeErros.entity;

import com.squad2.CentralDeErros.service.EncryptService;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "name")
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Email
    @Column(name = "email")
    @Size(min = 1, max = 200)
    private String email;

    @NotNull
    @Column(name = "password")
    @Size(min = 6, max = 200)
    private String password;

    @NotNull
    @CreatedDate
    @Column (name = "dateTime")
    @Size(min = 6, max = 200)
    private String dateTime;

//Get & Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


}
