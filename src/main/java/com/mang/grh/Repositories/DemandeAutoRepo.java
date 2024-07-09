package com.mang.grh.Repositories;

import com.mang.grh.entities.Autorisation;
import com.mang.grh.entities.DemandeAuto;
import com.mang.grh.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeAutoRepo extends JpaRepository<DemandeAuto, Long> {

    @Query("select u from DemandeAuto u where u.etatdem = ?1")
    List<DemandeAuto> fetchbyEtatdemAuto(String etat);
}
