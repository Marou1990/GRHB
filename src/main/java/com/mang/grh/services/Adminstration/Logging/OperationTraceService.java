package com.mang.grh.services.Adminstration.Logging;

import com.mang.grh.Repositories.Adminstration.Logging.OperationTraceRepository;
import com.mang.grh.entities.Administration.Logging.OperationTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationTraceService {
    @Autowired
    private OperationTraceRepository repository;

    public List<OperationTrace> getAllTraces() {
        return repository.findAll();
    }

    public void saveTrace(OperationTrace trace) {
        repository.save(trace);
    }
}
