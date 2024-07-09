package com.mang.grh.services.Adminstration;

import com.mang.grh.Repositories.Adminstration.RefDetailRepo;
import com.mang.grh.entities.Administration.DetailProfil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefDetProfilService {

    @Autowired
    private RefDetailRepo refdetprofilrep ;


    @Transactional
    public DetailProfil adddetprofil(DetailProfil det ){

        return refdetprofilrep.save(det);
    }

    public void deletedetprofil(DetailProfil det ){
         refdetprofilrep.delete(det);
    }

    public List<DetailProfil> fetchalldetprofil(){
        return refdetprofilrep.findAll();
    }


}
