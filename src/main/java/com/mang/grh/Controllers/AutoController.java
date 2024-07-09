package com.mang.grh.Controllers;

import com.mang.grh.entities.Autorisation;
import com.mang.grh.entities.Employee;
import com.mang.grh.services.autorisationser;
import com.mang.grh.services.emplyeeser;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/autorisation")
public class AutoController {

    @Autowired
    private autorisationser autoser;
    @Autowired
    private emplyeeser empser;


    @PostMapping("/autorisations")
    public Autorisation addAutorisation( @RequestBody Autorisation autorisation){
        return autoser.adautorisation(autorisation);
    }

    @GetMapping("/autorisations")
    public List<Autorisation> fetchAutorisationList()
    {
        return autoser.fetchAutorisationList();
    }


    // Delete operation
    @DeleteMapping("/autorisations/{id}")

    public String deleteAutorisationById(@PathVariable("id")
                                     Long AutorisationId)
    {
        autoser.deleteAutorisation(AutorisationId);
        return "Deleted Successfully";
    }

    @GetMapping("/getautorisations/{id}")
    @Operation(summary = "get a employee by id")
    public List<Autorisation> getAutorisation(@PathVariable("id") Long employeeId)

    {
        Employee emp = empser.fetchEmployee(employeeId);

        return  autoser.getautoemploye(emp) ;
    }
}
