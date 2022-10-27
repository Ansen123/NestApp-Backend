package com.nestdigital.nestApp.Controller;

import com.nestdigital.nestApp.Dao.AdminDao;
import com.nestdigital.nestApp.Model.AdminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addEmp", consumes = "application/json", produces = "application/json")
    public String AddEmployee(@RequestBody AdminModel add){
        dao.save(add);
        return "{status:Success}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewEmp")
    public List<AdminModel> viewUser(){
        return (List<AdminModel>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchEmp",consumes = "application/json",produces = "application/json")
    public List<AdminModel>searchEmp(@RequestBody AdminModel search){
        return (List<AdminModel>) dao.searchEmp(search.getEmpCode());
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/delete")
    @Transactional
    public String deleteEmp(@RequestBody AdminModel delete) {
        dao.deleteEmployeeByEmp_code(delete.getEmpCode());
        return "{status:Success}";
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/upadate")
    @Transactional
    public String updateEmp(@RequestBody AdminModel update){
        dao.edit(update.getAddress(),update.getEmail(),update.getName(),update.getPhoneNumber(),update.getDob(),update.getJoinDate(),update.getPassword(),update.getUserName(),update.getEmpCode());
        return "{Status:Success}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/signin",consumes = "application/json",produces = "application/json")
    public List<AdminModel> siginIn(@RequestBody AdminModel e){
        return (List<AdminModel>) dao.SignupBy(e.getUserName(),e.getPassword());
    }
    }
