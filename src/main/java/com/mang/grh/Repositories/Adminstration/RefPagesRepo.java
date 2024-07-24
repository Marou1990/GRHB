package com.mang.grh.Repositories.Adminstration;

import com.mang.grh.entities.Administration.RefPages;
import com.mang.grh.entities.Administration.RefProfil;
import com.mang.grh.entities.Autorisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefPagesRepo  extends JpaRepository<RefPages, Long> {

    @Query("SELECT u FROM RefPages u WHERE u.typePage = 'M'")
    List<RefPages> findParentPages();
    @Query("SELECT u FROM RefPages u WHERE u.typePage = 'SM'")
    List<RefPages> findSModule();
    @Query("SELECT u FROM RefPages u WHERE u.typePage = 'P'")
    List<RefPages> findPages();
    @Query("SELECT u FROM RefPages u WHERE u.typePage = 'SM' and u.code_prt= ?1 ")
    List<RefPages> findSModulebyPrt(Long cdeprt);
    @Query("SELECT u FROM RefPages u WHERE u.typePage = 'P' and u.code_prt= ?1 ")
    List<RefPages> findPagesbyPrt(Long cdeprt);
}
