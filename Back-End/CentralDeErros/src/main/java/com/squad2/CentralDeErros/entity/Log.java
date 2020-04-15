package com.squad2.CentralDeErros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.squad2.CentralDeErros.entity.enumerate.Environment;
import com.squad2.CentralDeErros.entity.enumerate.Level;
import com.squad2.CentralDeErros.entity.enumerate.Status;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="logs")
@Getter
@Setter
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Level level;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Environment environment;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Status status;

    @Column
    @NotNull
    @Size(min = 1, max = 255)
    private String eventDescription;

    @Column
    @NotNull
    @Size(min = 1, max = 255)
    private String eventLog;

    @Column
    @NotNull
    @Size(min = 7, max = 15)
    private String source;

    @Column
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "USER_ID")
    private User user;

}
