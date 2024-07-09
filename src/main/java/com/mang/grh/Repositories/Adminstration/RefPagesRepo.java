package com.mang.grh.Repositories.Adminstration;

import com.mang.grh.entities.Administration.RefPages;
import com.mang.grh.entities.Autorisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefPagesRepo  extends JpaRepository<RefPages, Long> {
}
