package com.mang.grh.Repositories;

import com.mang.grh.Statistiques.DemandeAutoStatsDTO;
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


    @Query("SELECT new com.mang.grh.Statistiques.DemandeAutoStatsDTO(FUNCTION('MONTH', d.datedemande), d.etatdem, COUNT(d)) " +
            "FROM DemandeAuto d " +
            "where d.etatdem =  ?1 " +
            "GROUP BY FUNCTION('MONTH', d.datedemande), d.etatdem " +
            "ORDER BY FUNCTION('MONTH', d.datedemande) DESC")
    List<DemandeAutoStatsDTO> findDemandeAutoStats(String etat);

}
