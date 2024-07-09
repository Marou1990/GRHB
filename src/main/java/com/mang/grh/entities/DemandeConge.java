package com.mang.grh.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name ="Demandeconge")
@NoArgsConstructor
public class DemandeConge {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id ;

    private Date datedemande ;
    private String etatdem;
    private Boolean statusdem ;
    private Date datedebutcg;
    private Date dfincg;
    private Date datedebutdeffet;
    private Date dfindeffet;
    private Integer kuticreat;
    private Integer kutimodif;
    private String Observation;
    private String Natconge;

    @ManyToOne
    @JoinColumn(name = "employee_Id")
    private Employee employee ;

    public DemandeConge(String observation, String natconge,
                        Date datedeb,Date datefin,
                        Employee employee) {
        Observation = observation;
        Natconge = natconge;
        datedebutcg=datedeb;
        dfincg=datefin;
        this.employee = employee;
    }
}
