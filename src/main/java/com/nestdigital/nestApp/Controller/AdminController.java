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
    }
