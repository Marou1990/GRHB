package com.mang.grh.Repositories.Registration;

import com.mang.grh.entities.Registration.PasswordResetToken;
import com.mang.grh.entities.Registration.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
    PasswordResetToken findByUser(User user);
}