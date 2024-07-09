package com.mang.grh.services;

import com.mang.grh.Repositories.AutorisationRepo;
import com.mang.grh.Repositories.EmployeeRepo;
import com.mang.grh.entities.Autorisation;
import com.mang.grh.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class emplyeeser {

    @Autowired
    EmployeeRepo emprep;
    @Autowired
    autorisationser autoser;
    @Autowired
    AutorisationRepo autorep;



    public Employee addemployee(Employee emp)

    {
        try {
            // Create a Calendar instance
            Calendar calendar = Calendar.getInstance();
            Date date = new Date();
            // Get the year, month, and day of the month
            int year = calendar.get(Calendar.YEAR);
            // Month values are 0-based (0 = January, 11 = December)
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            emprep.save(emp);
            // add two service auto
            Autorisation firstauto = new Autorisation(month+1, year, date, null, "auto ur", true, 1,emp) ;
            Autorisation secondauto = new Autorisation(month+1, year, date, null, "auto ur", true, 2,emp) ;
            autoser.adautorisation(firstauto);
            autoser.adautorisation(secondauto);
            return  emp;
        }catch(Exception ex ){
            return  null;
        }




    }

    // Update operation
    public Employee updateEmployee(Employee upemp) {
        Employee em = emprep.findById(upemp.getId()).get();

        if (Objects.nonNull(upemp.getAddress()) && !"".equalsIgnoreCase(upemp.getAddress())) {
            em.setAddress(upemp.getAddress());
        }

        if (Objects.nonNull(upemp.getEmail()) && !"".equalsIgnoreCase(upemp.getEmail())) {
            em.setEmail(upemp.getEmail());
        }
        if (Objects.nonNull(upemp.getLastName()) && !"".equalsIgnoreCase(upemp.getLastName())) {
            em.setLastName(upemp.getLastName());
        }
        if (Objects.nonNull(upemp.getFirstName()) && !"".equalsIgnoreCase(upemp.getFirstName())) {
            em.setFirstName(upemp.getFirstName());
        }
        if (Objects.nonNull(upemp.getEtatCivil()) && !"".equalsIgnoreCase(upemp.getEtatCivil())) {
            em.setEtatCivil(upemp.getEtatCivil());
        }
        if (Objects.nonNull(upemp.getPhoneNumber())) {
            em.setPhoneNumber(upemp.getPhoneNumber());
        }
        return emprep.save(em);
    }


    public List<Employee> fetchEmployeeList() {
        return emprep.findAll();
    }
    public Employee fetchEmployee(Long idemp) {

        return emprep.findById(idemp).get();
        /*List<Autorisation> autorisations  = (List<Autorisation>) autoser.getautoemploye(emp);
        Set<Autorisation> hSet = new HashSet<Autorisation>();
        for (Autorisation x : autorisations)
            hSet.add(x);


        System.out.println(hSet.toArray().length);
        emp.setAutorisations(hSet);*/


    }

    //retourner employee par matricule

   public Employee getEmployeeByMatricule(String matsearch){

        return emprep.findByEmployeeByMatricule(matsearch) ;

   }
    public void deleteEmployee (Long empid){

        Optional<Employee> employee  = emprep.findById(empid);
        List<Autorisation> autorisations  = (List<Autorisation>) autoser.getautoemploye(employee.get());

        employee.ifPresent(emp -> {

            autorisations.forEach(innerList -> {
                autoser.deleteAutorisation(innerList.getId())  ;
                System.out.println("deelted "+innerList.getId());

            });

            emprep.delete(emp);

        });

    }


}
