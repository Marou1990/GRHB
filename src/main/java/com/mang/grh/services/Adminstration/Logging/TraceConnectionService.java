package com.mang.grh.services.Adminstration.Logging;

import com.mang.grh.Repositories.Adminstration.Logging.ConnectionTraceRepository;
import com.mang.grh.entities.Administration.Logging.OperationTrace;
import com.mang.grh.entities.Administration.Logging.TraceConnection;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraceConnectionService {

    @Autowired
    private ConnectionTraceRepository repository;

    public TraceConnection saveTraceConnection(TraceConnection traceConnection) {
        return repository.save(traceConnection);
    }

    @Transactional
    public void updateDatedecnx(Long Id) {
        repository.updateDatedecnxById(Id);
    }

    public List<TraceConnection>  getalltracescnx() {
        return repository.findAllByOrderByDatecnxDesc();
    }
}
