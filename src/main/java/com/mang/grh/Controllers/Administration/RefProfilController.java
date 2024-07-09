package com.mang.grh.Controllers.Administration;

import com.mang.grh.entities.Administration.RefPages;
import com.mang.grh.entities.Administration.RefProfil;
import com.mang.grh.services.Adminstration.RefPageService;
import com.mang.grh.services.Adminstration.RefProfilService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/admin/profil")
public class RefProfilController {

    @Autowired
    private RefProfilService refprofilser;


    @PostMapping("/addprofil")
    @Operation(summary = "save a page")
    public RefProfil addProfil(@RequestBody RefProfil profil){
        return refprofilser.addprofil(profil) ;
    }

    @Operation(summary = "delete a employee by id")
    @DeleteMapping("/delete-profil")
    public void deleteProfil(@RequestBody  RefProfil profil){
        refprofilser.deleteprofil(profil);
    }
    @GetMapping("/profils")
    @Operation(summary = "get all pages")
    public List<RefProfil> getallProfils(){
        return refprofilser.getallprofil();
    }

}
