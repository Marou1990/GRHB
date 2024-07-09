package com.mang.grh.entities;

import com.mang.grh.utils.MatriculeGenerator;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name ="Employee")
public class Employee implements Serializable {
     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long Id;

     private String firstName ;
     private String lastName;
     private Integer Yearexper;
     private String    Identifiant ;
     private String  Matricule  = MatriculeGenerator.generateMatricule();
     private String  Email ;
     private String  Address ;
     private Long phoneNumber ;
     private Date recruitmentdate ;
     private String  EtatCivil ;
     private Boolean status;

     private Date datecreat =new Date();
     private Date datemodif;
     private Integer kuticreat = 1;
     private Integer kutimodif;

     @OneToMany(mappedBy="employee")
     private Set<Autorisation> autorisations;


     @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private Set<DemandeAuto> demandes;
     @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private Set<DemandeConge> demandesconge;


     public Employee() {
     }

     public Employee(String firstName, String lastName, Integer yearexper, String identifiant, String email, String address, Long phoneNumber, Date recruitmentdate, String etatCivil, Boolean status) {

          this.firstName = firstName;
          this.lastName = lastName;
          Yearexper = yearexper;
          Identifiant = identifiant;
          Email = email;
          Address = address;
          this.phoneNumber = phoneNumber;
          this.recruitmentdate = recruitmentdate;
          EtatCivil = etatCivil;
          this.status = status;

     }
}
