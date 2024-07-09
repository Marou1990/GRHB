package com.mang.grh.Repositories;

import com.mang.grh.entities.Autorisation;
import com.mang.grh.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Query("select u from Employee u where u.Matricule = ?1")
    Employee findByEmployeeByMatricule(String matrsearch);
}
