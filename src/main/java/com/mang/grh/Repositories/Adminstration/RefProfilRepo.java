package com.mang.grh.Repositories.Adminstration;

import com.mang.grh.entities.Administration.RefProfil;
import com.mang.grh.entities.Autorisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RefProfilRepo extends JpaRepository<RefProfil, Long> {

    @Query("SELECT u FROM RefProfil u WHERE u.CodeProfil = ?1")
    RefProfil findProfilBycode(Long codeProfil);
}
