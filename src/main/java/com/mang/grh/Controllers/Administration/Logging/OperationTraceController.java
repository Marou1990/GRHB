package com.mang.grh.Controllers.Administration.Logging;

import com.mang.grh.entities.Administration.Logging.OperationTrace;
import com.mang.grh.services.Adminstration.Logging.OperationTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/traces")
public class OperationTraceController {
    @Autowired
    private OperationTraceService service;

    @GetMapping
    public List<OperationTrace> getTraces() {
        return service.getAllTraces();
    }

    @PostMapping
    public void saveTrace(@RequestBody OperationTrace trace) {
        service.saveTrace(trace);
    }
}
