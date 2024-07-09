package com.mang.grh.Repositories;

import com.mang.grh.entities.Autorisation;
import com.mang.grh.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorisationRepo extends JpaRepository<Autorisation, Long> {

    @Query("select u from Autorisation u where u.employee = ?1")
    List<Autorisation> findByEmployee(Employee emp);

    @Query("select u from Autorisation u where u.numbauto = ?1 and u.MonthAuto = ?2  and u.employee =?3")
    Autorisation findByNumeroAutorisation(Integer num,Integer monthauto,Employee e );
}
