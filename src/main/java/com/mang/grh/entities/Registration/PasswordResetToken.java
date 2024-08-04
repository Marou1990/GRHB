package com.mang.grh.entities.Registration;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;



@Entity
@Data
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id", unique = true)
    private User user;

    private Date expiryDate;

    public PasswordResetToken(String token, User user) {
        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate();
    }

    private Date calculateExpiryDate() {
        Integer EXPIRATION_HOURS = 24;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, EXPIRATION_HOURS);
        return calendar.getTime();
    }

    public PasswordResetToken() {
    }
}
