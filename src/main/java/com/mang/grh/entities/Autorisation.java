package com.mang.grh.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Month;
import java.util.Date;

@Entity
@Data
@Table(name ="Autorisation")
public class Autorisation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Integer MonthAuto;
    private Integer YearAuto;
    private Date Datedebut;
    private Date Datefin ;
    private String typeauto;
    private Boolean stattusAuto;
    private Integer numbauto ;


    @ManyToOne
    @JoinColumn(name="employeeUser_id", nullable=false)
    private Employee employee;




    public Autorisation() {
    }

    public Autorisation(Integer month, Integer year, Date datedebut, Date datefin, String typeauto, Boolean stattusAuto, Integer autonumber,Employee employee) {
        MonthAuto = month;
        YearAuto = year;
        Datedebut = datedebut;
        Datefin = datefin;
        this.typeauto = typeauto;
        this.stattusAuto = stattusAuto;
        numbauto = autonumber;
        this.employee=employee ;
    }
}
