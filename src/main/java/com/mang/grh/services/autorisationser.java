package com.mang.grh.services;

import com.mang.grh.Repositories.AutorisationRepo;
import com.mang.grh.entities.Autorisation;
import com.mang.grh.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class autorisationser {

    @Autowired
    AutorisationRepo autorepo ;

    public List<Autorisation> getautoemploye(Employee e){
       return (List<Autorisation>) autorepo.findByEmployee(e);

    }

    public Autorisation adautorisation(Autorisation emp)
    {
        return  autorepo.save(emp);
    }

    public void deleteAutorisation (Long emid){
        Autorisation auto = autorepo.findById(emid).get();
        autorepo.delete(auto);

    }

    public List<Autorisation> fetchAutorisationList() {
        return autorepo.findAll();
    }

    public Autorisation getAutorisationbyID(Integer num,Integer currentmonth,Employee e) {
        return autorepo.findByNumeroAutorisation(num,currentmonth,e);
    }



}
