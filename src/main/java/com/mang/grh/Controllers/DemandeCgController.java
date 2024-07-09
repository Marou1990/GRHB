package com.mang.grh.Controllers;


import com.mang.grh.entities.DemandeAuto;
import com.mang.grh.entities.DemandeConge;
import com.mang.grh.entities.Employee;
import com.mang.grh.services.demautoser;
import com.mang.grh.services.demcongeser;
import com.mang.grh.services.emplyeeser;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/demcg")
public class DemandeCgController {

    @Autowired
    private emplyeeser empser;
    @Autowired
    private demcongeser demcgser;


    // Save operation
    @PostMapping("/{id}/adddemandecg")
    @Operation(summary = "save a demande cg")
    public DemandeConge saveDemandecg(
            @PathVariable Long id,
            @RequestBody DemandeConge dem)
    {
        Employee emp = empser.fetchEmployee(id);
        dem.setEmployee(emp);
        dem.setDatedemande(new Date());
        dem.setDatedebutdeffet(new Date());
        dem.setEtatdem("I");
        dem.setStatusdem(true);
        return demcgser.createdemandecg(dem);
    }

    // Read operation
    @GetMapping("/demandescg")
    @Operation(summary = "get all demandes cg")
    public List<DemandeConge> fetchEmployeeListcg()

    {
        return demcgser.fetchalldemandecg();
    }


    @Operation(summary = "update a employee by id")
    @PutMapping("/edit-demandecg")
    public DemandeConge updateDemandecg(@RequestBody DemandeConge p)
    {

        return demcgser.updatedemcg(p);
    }

    // Read operation
    @GetMapping("/demandescgbyetat/{etat}")
    @Operation(summary = "get all demandes cg byetat ")
    public List<DemandeConge> fetchEmployeeListbyEtat(@PathVariable String etat)
    {
        return demcgser.fetchalldemandebyetat(etat);
    }

    @Operation(summary = "update a employee by id")
    @PutMapping("/edit-demandecg/{iddem}/{eta}")
    public DemandeConge updateDemandecgbyet(@PathVariable Long iddem,@PathVariable String eta)
    {
        DemandeConge demcg = demcgser.findbyIddem(iddem);
        demcg.setEtatdem(eta);
        return demcgser.createdemandecg(demcg);
    }



}
