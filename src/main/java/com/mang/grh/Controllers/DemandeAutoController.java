package com.mang.grh.Controllers;

import com.mang.grh.entities.Autorisation;
import com.mang.grh.entities.DemandeAuto;
import com.mang.grh.entities.Employee;
import com.mang.grh.services.autorisationser;
import com.mang.grh.services.demautoser;
import com.mang.grh.services.emplyeeser;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/demautorisation")

public class DemandeAutoController {


    @Autowired
    private emplyeeser empser;
    @Autowired
    private demautoser demauser;
    @Autowired
    private autorisationser autoser;


    // Save operation
    @PostMapping("/{id}/adddemande")
    @Operation(summary = "save a demande")
    public DemandeAuto saveDemande(
            @PathVariable Long id,
            @RequestBody DemandeAuto dem)
    {
        Employee emp = empser.fetchEmployee(id);
        dem.setEmployee(emp);
        dem.setDatedemande(new Date());
        dem.setDatedebutdeffet(new Date());
        dem.setEtatdem("I");
        dem.setStatusdem(true);
        return demauser.createdemandeauto(dem);
    }

    // Read operation
    @GetMapping("/demandes")
    @Operation(summary = "get all demandes")
    public List<DemandeAuto> fetchEmployeeList()
    {
        return demauser.fetchalldemande();
    }

    // Read operation
    @GetMapping("/demandesbyetat/{etat}")
    @Operation(summary = "get all demandes byetat ")
    public List<DemandeAuto> fetchEmployeeListbyEtat(@PathVariable String etat)
    {
        return demauser.fetchalldemandebyetat(etat);
    }


    @Operation(summary = "update a employee by id")
    @PutMapping("/edit-demandeauto")
    public DemandeAuto updateDemandeAuto(@RequestBody DemandeAuto p)
    {
        return demauser.updatedem(p);
    }

    @Operation(summary = "update a employee by id")
    @PutMapping("/edit-demandeauto/{iddem}/{eta}")
    public DemandeAuto updateDemandeAutobyet(@PathVariable Long iddem,@PathVariable String eta)
    {
        Calendar calendar = Calendar.getInstance();
        Integer month = calendar.get(Calendar.MONTH)+1; //current month
        DemandeAuto demaut = demauser.findbyIddem(iddem).get();
        System.out.println("num dem "+demaut.getNumauto());
        System.out.println("num dem  22"+month);
        Autorisation autocurrent  =  autoser.getAutorisationbyID(demaut.getNumauto(),month,demaut.getEmployee());
        demaut.setEtatdem(eta);
        if(eta.equals("A")) {
            autocurrent.setStattusAuto(false); // non utilise => utilisé
            autoser.adautorisation(autocurrent);
        }

        return demauser.createdemandeauto(demaut);
    }
}
