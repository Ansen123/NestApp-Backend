package com.nestdigital.nestApp.Controller;

import com.nestdigital.nestApp.Dao.SecurityDao;
import com.nestdigital.nestApp.Model.AdminModel;
import com.nestdigital.nestApp.Model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/Sadd",consumes = "application/json",produces = "application/json")
    public String AddSecurity(@RequestBody SecurityModel adds){
        dao.save(adds);
        return "{Status:Success}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewSecurty")
    public List<SecurityModel> viewS(){
        return (List<SecurityModel>) dao.findAll();
    }




}
