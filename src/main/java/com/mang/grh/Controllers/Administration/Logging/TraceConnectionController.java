package com.mang.grh.Controllers.Administration.Logging;

import com.mang.grh.entities.Administration.Logging.OperationTrace;
import com.mang.grh.entities.Administration.Logging.TraceConnection;
import com.mang.grh.entities.Registration.User;
import com.mang.grh.services.Adminstration.Logging.TraceConnectionService;
import com.mang.grh.services.Adminstration.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/traceconnection")
public class TraceConnectionController {


    @Autowired
    private TraceConnectionService service;

    @Autowired
    private UserService userservice ;

    @PostMapping("/savetrace/{id}")
    public TraceConnection saveTraceConnection(@PathVariable Long id,@RequestBody TraceConnection traceConnection) {
        System.out.println("id user  :: "+id);
        User user = userservice.getuserbyid(id) ;
        traceConnection.setUser(user);
        traceConnection.setDatedecnx(null);
        return service.saveTraceConnection(traceConnection);
    }

    @PutMapping("/updatetrace/{id}")
    public void updateDatedecnx(@PathVariable Long id) {
        service.updateDatedecnx(id);
    }


    @GetMapping("/alltracescnx")
    public List<TraceConnection> getTracescnx() {
        return service.getalltracescnx();
    }
}
