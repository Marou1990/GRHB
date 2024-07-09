package com.mang.grh.Controllers.Administration;

import com.mang.grh.Repositories.Adminstration.RefDetailRepo;
import com.mang.grh.Repositories.Adminstration.RefProfilRepo;
import com.mang.grh.entities.Administration.DetailProfil;
import com.mang.grh.entities.Administration.RefProfil;
import com.mang.grh.exception.ResourceNotFoundException;
import com.mang.grh.services.Adminstration.RefDetProfilService;
import com.mang.grh.services.Adminstration.RefProfilService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/admin/detailprfl")
public class DetailProfilController {

    @Autowired
    private RefDetProfilService refdetprofilser;
    @Autowired
    private RefDetailRepo refdetrepo  ;
    @Autowired
    private RefProfilRepo refProfilRepo ;


    @PostMapping("/adddetprf/{codeprofil}")
    @Operation(summary = "save a page")
    public DetailProfil addProfil(@PathVariable (value = "codeprofil") Long codeprofil,
                                  @RequestBody DetailProfil detprofil){
       System.out.println(codeprofil);
       detprofil.setProfil(refProfilRepo.findProfilBycode(codeprofil));
        return refdetprofilser.adddetprofil(detprofil) ;
    }

    @Operation(summary = "delete a employee by id")
    @DeleteMapping("/delete-detprf")
    public void deleteDetPrf(@RequestBody  DetailProfil detprofil){
        refdetprofilser.deletedetprofil(detprofil);
    }
    @GetMapping("/detailsprf")
    @Operation(summary = "get all detail profils")
    public List<DetailProfil> getalldetPrf(){
        return refdetprofilser.fetchalldetprofil();
    }

}
