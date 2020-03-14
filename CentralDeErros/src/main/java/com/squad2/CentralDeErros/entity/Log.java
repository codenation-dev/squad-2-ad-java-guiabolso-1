package com.squad2.CentralDeErros.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLog;

    @Column
    @NotNull
    private String nivel;

    @Column
    @NotNull
    private String ambiente;

    @Column
    @NotNull
    private String descricaoEvento;

    @Column
    @NotNull
    private String logEvento;

    @Column
    @NotNull
    private String origem;

    @Column
    @NotNull
    private Date data;

    @ManyToOne
    @NotNull
    private Usuario idUsuario;

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getLogEvento() {
        return logEvento;
    }

    public void setLogEvento(String logEvento) {
        this.logEvento = logEvento;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }
}
