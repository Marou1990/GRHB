package com.mang.grh.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
@Entity
@Table(name ="Demandeauto")

@NoArgsConstructor
public class DemandeAuto {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id ;

    private Date datedemande ;
    private String etatdem;
    private Boolean statusdem ;
    private Date datedebutdeffet;
    private Date dfindeffet;
    private Integer kuticreat;
    private Integer kutimodif;
    private String Observation;
    private Integer numauto;



    @ManyToOne
    @JoinColumn(name = "employee_Id")
    private Employee employee ;

    public DemandeAuto(String observation,Employee employee,Integer numauto) {

        this.Observation = observation;
        this.employee = employee;
        this.setDatedemande(new Date());
        this.setDatedebutdeffet(new Date());
        this.setEtatdem("I");
        this.setStatusdem(true);
        this.setNumauto(numauto);
    }



}
