package com.mang.grh.entities.Administration.Logging;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mang.grh.entities.Administration.RefProfil;
import com.mang.grh.entities.Registration.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name ="TraceConnection")
public class TraceConnection {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
    private String status ;
    private Date datecnx ;
    private Date datedecnx;
    private String AdrMac ;
    private String AdrIP ;
    private Date dateop ;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public TraceConnection() {
    }

    public TraceConnection(String status, Date datecnx, Date datedecnx, String adrMac, String adrIP, User user,Date dateop) {
        this.status = status;
        this.datecnx = datecnx;
        this.datedecnx = datedecnx;
        this.AdrMac = adrMac;
        this.AdrIP = adrIP;
        this.dateop = dateop;
        this.user = user;
    }
}
