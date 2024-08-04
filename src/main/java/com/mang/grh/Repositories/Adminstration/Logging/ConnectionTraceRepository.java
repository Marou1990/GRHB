package com.mang.grh.Repositories.Adminstration.Logging;

import com.mang.grh.entities.Administration.Logging.OperationTrace;
import com.mang.grh.entities.Administration.Logging.TraceConnection;
import com.mang.grh.entities.Autorisation;
import com.mang.grh.entities.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionTraceRepository extends JpaRepository<TraceConnection, Long> {

    @Modifying
    @Transactional
    @Query("update TraceConnection u set u.datedecnx = current_timestamp , u.status = 'N' where u.Id = ?1")
    int updateDatedecnxById(Long Id);

    List<TraceConnection> findAllByOrderByDatecnxDesc();

}
