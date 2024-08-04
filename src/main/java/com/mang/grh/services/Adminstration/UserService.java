package com.mang.grh.services.Adminstration;


import com.mang.grh.Repositories.Registration.PasswordResetTokenRepository;
import com.mang.grh.Repositories.Registration.UserRepository;
import com.mang.grh.entities.Registration.PasswordResetToken;
import com.mang.grh.entities.Registration.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private JavaMailSender mailSender;

    private  int EXPIRATION_HOURS = 24;
    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken existingToken = tokenRepository.findByUser(user);
        if (existingToken != null) {
            tokenRepository.delete(existingToken);
        }
        PasswordResetToken myToken = new PasswordResetToken();
        myToken.setToken(token);
        myToken.setUser(user);
        myToken.setExpiryDate(calculateExpiryDate(EXPIRATION_HOURS));
        tokenRepository.save(myToken);
    }

    private Date calculateExpiryDate(int expiryTimeInHours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, expiryTimeInHours);
        return calendar.getTime();
    }

    public void sendEmail(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Reset Password");
        message.setText("To reset your password, click the link below:\n" + "http://localhost:4200/reset-password?token=" + token);
        System.out.println("mail object :: "+message.getText());
        mailSender.send(message);
    }

    public User getuserbyid(Long iduser){
       return userRepository.getById(iduser) ;
    }

}
