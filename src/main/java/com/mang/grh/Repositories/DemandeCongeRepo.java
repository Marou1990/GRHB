package com.mang.grh.Repositories;

import com.mang.grh.entities.DemandeAuto;
import com.mang.grh.entities.DemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeCongeRepo extends JpaRepository<DemandeConge, Long> {

    @Query("select u from DemandeConge u where u.etatdem = ?1")
    List<DemandeConge> fetchbyEtatdemcg(String etat);

}
