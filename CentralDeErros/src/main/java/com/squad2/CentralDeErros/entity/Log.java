package com.squad2.CentralDeErros.entity;

import com.squad2.CentralDeErros.entity.enumerate.Ambiente;
import com.squad2.CentralDeErros.entity.enumerate.Nivel;
import com.squad2.CentralDeErros.entity.enumerate.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_LOG")
    private Long idLog;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Nivel nivel;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Ambiente ambiente;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Status status;

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
    @JoinColumn(name = "ID_USUARIO")
    private Usuario idUsuario;

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
}
