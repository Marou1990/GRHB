package com.mang.grh.entities.Administration;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name ="RefPages")
public class RefPages implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
    private String Libellepg ;
    private String goAction;
    private Date datedebut;
    private Date datefin ;
    private Boolean status ;
    private Integer kuticreat ;
    private Integer kutimodif ;

    public RefPages() {
    }

    public RefPages(String libellepg, String goAction, Boolean status,Date datedebut,Date datefin) {
        Libellepg = libellepg;
        this.goAction = goAction;
        this.status = status;
        this.datedebut=datedebut;
        this.datefin=datefin;
    }
}
