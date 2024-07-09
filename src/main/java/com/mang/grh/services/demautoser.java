package com.mang.grh.services;

import com.mang.grh.Repositories.DemandeAutoRepo;
import com.mang.grh.entities.DemandeAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class demautoser {

    @Autowired
    private DemandeAutoRepo demandeAutoRepo ;


    public DemandeAuto createdemandeauto(DemandeAuto demauto){
       System.out.println("cc :: "+demauto.getEmployee().getId());
       return  demandeAutoRepo.save(demauto)  ;
    }


    public List<DemandeAuto> fetchalldemande(){
        return demandeAutoRepo.findAll();
    }

    public List<DemandeAuto> fetchalldemandebyetat(String etat){
        return demandeAutoRepo.fetchbyEtatdemAuto(etat);
    }

    public Optional<DemandeAuto> findbyIddem(Long iddemau){
        return demandeAutoRepo.findById(iddemau);
    }

    public DemandeAuto updatedem(DemandeAuto demauto){
        return demandeAutoRepo.save(demauto);
    }
}
