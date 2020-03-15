package com.squad2.CentralDeErros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
    @Id
    private Long idUser;

    @Column
    @NotNull
    private String name;

}
