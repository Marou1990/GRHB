package com.mang.grh.Statistiques;


import com.mang.grh.entities.Employee;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/stat")
public class StatiscticsController {

    @Autowired
    statisticsService statser ;



    @GetMapping("/statemplins")
    @Operation(summary = "get stat empl insc")
    public List<statisticsEmplinsc> fetchEmployeeListinsc()
    {   return statser.getstatempinscr();
    }

    @GetMapping("/statempecivil")
    @Operation(summary = "get stat empl insc")
    public List<Statempbyetatcivil> fetchEmployeeetatcivil()
    {
        return statser.getstatempletatcivil();
    }


    @GetMapping("/statautorisation/{etatdem}")
    public List<DemandeAutoStatsDTO> findDemandeAutoStats(@PathVariable  String etatdem)
    {
        return statser.findDemandeAutoStats(etatdem);
    }
}
