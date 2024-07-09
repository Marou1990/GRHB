package com.mang.grh.services.Adminstration;

import com.mang.grh.Repositories.Adminstration.RefProfilRepo;
import com.mang.grh.entities.Administration.RefProfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefProfilService {

    @Autowired
    private RefProfilRepo refprofilrep ;


    public RefProfil addprofil(RefProfil profil){
        return refprofilrep.save(profil);
    }

    public void deleteprofil(RefProfil profil){
         refprofilrep.delete(profil);
    }

    public List<RefProfil> getallprofil(){
        return refprofilrep.findAll();
    }
}
