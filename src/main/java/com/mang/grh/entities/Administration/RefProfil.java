package com.mang.grh.entities.Administration;

import com.mang.grh.entities.Autorisation;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name ="RefProfil")
public class RefProfil  implements Serializable {
    private static final long serialVersionUID = 1L;
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CodeProfil;
    private String Libelle;
    private Date datedebut;
    private Date datefin;
    private Boolean status ;
    private Integer kuticreat;
    private Integer kutimodif;

    /*@OneToMany(mappedBy="profil")
    private Set<DetailProfil> detailsProfils;*/


    public RefProfil(String libelle, Boolean status,Date datedebut,Date datefin) {
        Libelle = libelle;
        this.status = status;
        this.datedebut=datedebut;
        this.datefin=datefin;
    }

    public RefProfil() {
    }


}
