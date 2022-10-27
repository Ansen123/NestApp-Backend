package com.nestdigital.nestApp.Controller;

import com.nestdigital.nestApp.Dao.SecurityDao;
import com.nestdigital.nestApp.Model.AdminModel;
import com.nestdigital.nestApp.Model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/Sadd", consumes = "application/json", produces = "application/json")
    public String AddSecurity(@RequestBody SecurityModel addSecurity) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = String.valueOf(dt.format(now));
        addSecurity.setsDate(currentdate);

        dao.save(addSecurity);
        return "{Status:Success}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewSecurty")
    public List<SecurityModel> viewS() {
        return (List<SecurityModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/deleteSecurity")
    @Transactional
    public String deleteSeurity(@RequestBody SecurityModel delete) {
        dao.deleteSecurity(delete.getsCode());
        return "{status:Success}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchSecurity",consumes = "application/json",produces = "application/json")
    public List<SecurityModel>searchSecurity(@RequestBody SecurityModel search){
        return (List<SecurityModel>)dao.searchSecurity(search.getsCode());
    }
}