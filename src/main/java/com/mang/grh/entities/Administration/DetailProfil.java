package com.mang.grh.entities.Administration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mang.grh.entities.Employee;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Table(name ="DetailProfil")
public class DetailProfil implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Long codePage;
    private Boolean status;
    private Boolean bmaint;
    private Date datedebut;
    private Date datefin ;
    private Integer kuticreat;
    private Integer kutimodif;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="profil_id", nullable=false)

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profil_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private RefProfil profil;

    public DetailProfil() {
    }

    public DetailProfil(Long codePage, Boolean status, Boolean bmaint,RefProfil profil) {
        this.codePage = codePage;
        this.status = status;
        this.bmaint = bmaint;
        this.profil = profil;
    }
}
