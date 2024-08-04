package com.mang.grh.Repositories.Adminstration.Logging;

import com.mang.grh.entities.Administration.Logging.OperationTrace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTraceRepository extends JpaRepository<OperationTrace, Long> {
}
