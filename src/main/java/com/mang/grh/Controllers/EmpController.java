package com.mang.grh.Controllers;

import com.mang.grh.entities.Employee;
import com.mang.grh.services.emplyeeser;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
    @RestController
    @RequestMapping("/api/employee")
    public class EmpController {

        @Autowired
        private emplyeeser empser;

        // Save operation
        @PostMapping("/addemployees")
        @Operation(summary = "save a employee")
        public Employee saveEmployee(
                @RequestBody Employee employee)
        {
            return empser.addemployee(employee);
        }

        // Read operation
        @GetMapping("/employees")
        @Operation(summary = "get all employees")
        public List<Employee> fetchEmployeeList()
        {
            return empser.fetchEmployeeList();
        }


       @Operation(summary = "update a employee by id")
      @PutMapping("/edit-employee")
      public Employee updateEmployee(@RequestBody Employee p) {
        return empser.updateEmployee(p);
      }

        // Read operation
        @GetMapping("/getemployees/{id}")
        @Operation(summary = "get a employee by id")
        public Employee getEmployee(@PathVariable("id") Long employeeId)
        {
            return  empser.fetchEmployee(employeeId) ;
        }

    // Read operation
    @GetMapping("/getemployeesbymat/{matricule}")
    @Operation(summary = "get a employee by Matricule")
    public Employee getEmployeebyMat(@PathVariable("matricule") String  matsearch)
    {
        return  empser.getEmployeeByMatricule(matsearch) ;
    }


        // Delete operation

        @Operation(summary = "delete a employee by id")
        @DeleteMapping("/delete-employees/{idemp}")
        public void deleteEmployeeById(@PathVariable("idemp") Long id) {
            empser.deleteEmployee(id);
        }

    }

