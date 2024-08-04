package com.mang.grh.Statistiques;

import com.mang.grh.Repositories.DemandeAutoRepo;
import com.mang.grh.Repositories.EmployeeRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class statisticsService {

    @Autowired
    EmployeeRepo emplrepo ;
    @Autowired
    DemandeAutoRepo demauto ;
   // private final EntityManagerFactory entityManagerFactory;

   /* @Autowired
    public statisticsService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }*/

    public List<statisticsEmplinsc>  getstatempinscr() {

        return emplrepo.getstatempinscr();
       /* List<statisticsEmplinsc> results = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT new com.mang.grh.Statistiques.statisticsEmplinsc(" +

                    "FUNCTION('YEAR', e.recruitmentdate), " +
                    "COUNT(e)  ) " +
                    "FROM Employee e " +
                    "GROUP BY FUNCTION('YEAR', e.recruitmentdate)";
            TypedQuery<statisticsEmplinsc> query = entityManager.createQuery(jpql, statisticsEmplinsc.class);
            results = query.getResultList();

            // Display the results
            for (statisticsEmplinsc stat : results) {
                System.out.println("Year: " + stat.getYear() + ", Count: " + stat.getCount());
            }

        } finally {
            // entityManagerFactory.close();
        }*/

    }


        public List<Statempbyetatcivil>  getstatempletatcivil() {
            List<Statempbyetatcivil> employeeCountDTOs = new ArrayList<>();
            List<Object[]> results = emplrepo.countEmployeesByEtatCivil();
            for (Object[] result : results) {
                String etatCivil = (String) result[0];
                Long count = (Long) result[1];
                employeeCountDTOs.add(new Statempbyetatcivil(etatCivil, count));
            }
            return employeeCountDTOs;
        }

    public List<DemandeAutoStatsDTO>  findDemandeAutoStats(String etatdem) {
      return demauto.findDemandeAutoStats(etatdem);
    }



}
