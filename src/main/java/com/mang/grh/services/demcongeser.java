package com.mang.grh.services;

import com.mang.grh.Repositories.DemandeAutoRepo;
import com.mang.grh.Repositories.DemandeCongeRepo;
import com.mang.grh.entities.DemandeAuto;
import com.mang.grh.entities.DemandeConge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class demcongeser {

    @Autowired
    private DemandeCongeRepo demandecongeRepo ;

    public DemandeConge createdemandecg(DemandeConge dem){
        return  demandecongeRepo.save(dem)  ;
    }


    public List<DemandeConge> fetchalldemandecg()
    {
        return demandecongeRepo.findAll();
    }


    public List<DemandeConge> fetchalldemandebyetat(String etat){
        return demandecongeRepo.fetchbyEtatdemcg(etat);
    }
    public DemandeConge updatedemcg(DemandeConge dem)
    {
        return demandecongeRepo.save(dem);
    }

    public DemandeConge findbyIddem(Long iddemau){
        return demandecongeRepo.findById(iddemau).get();
    }
}
