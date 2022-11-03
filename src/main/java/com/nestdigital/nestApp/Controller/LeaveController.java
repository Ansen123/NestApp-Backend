package com.nestdigital.nestApp.Controller;

import com.nestdigital.nestApp.Dao.LeaveDao;
import com.nestdigital.nestApp.Model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {
    @Autowired
    private LeaveDao leaveDao;

    @CrossOrigin("*")
    @PostMapping("/applyLeave")
    public String applyLeave(@RequestBody LeaveModel model){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        model.setApplyDate((String.valueOf(date.format(now))));
        model.setStatus(0);
        leaveDao.save(model);
        return "Leave Applied";
    }
    @Transactional
    @CrossOrigin("*")
    @PostMapping("/leaveStatus")
    public String changeLeaveStatus(@RequestBody LeaveModel model){
        leaveDao.changeStatusOfLeave(model.getId(), model.getStatus());
        return "Success'";
    }
    @CrossOrigin("*")
    @GetMapping("/viewAllLeaves")
    public List<Map<String,String>> viewAllLeaves(){
        return (List<Map<String, String>>) leaveDao.viewAllLeave();
    }
    @CrossOrigin("*")
    @PostMapping(path = "/viewLeaveById", consumes = "application/json",produces = "application/json")
    public  List<Map<String,String>> viewLeavesById(@RequestBody LeaveModel lm){
        return (List<Map<String, String>>) leaveDao.viewLeaveById(lm.getEmp_id());
    }
}

