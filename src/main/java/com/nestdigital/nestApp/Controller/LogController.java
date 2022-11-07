package com.nestdigital.nestApp.Controller;

import com.nestdigital.nestApp.Dao.LogDao;
import com.nestdigital.nestApp.Model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
@RestController
public class LogController {

    @Autowired
    private LogDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/checkin",consumes = "application/json",produces = "application/json")
    public String CheckIn(@RequestBody LogModel log)
    {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        log.setLogin_time((String.valueOf(dt.format(now))) );
        dao.save(log);
        return "{Status:'Success}";
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/checkout",consumes = "application/json",produces = "application/json")
    public String Checkout(@RequestBody LogModel log)
    {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        log.setLogout_time((String.valueOf(dt.format(now))));
        dao.Checkout(log.getLogout_sec_id(), log.getLogout_time(), log.getEmp_id());
        return "{Status:'Success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewlogdetails")
    public List<Map<String,String>> ViewLogDetails()
    {
        return (List<Map<String, String>>) dao.viewallLogs();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewlogbyid",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> ViewByIdLog(@RequestBody LogModel log){
        return (List<Map<String, String>>) dao.ViewByIdLogs(log.getEmp_id());
    }

}