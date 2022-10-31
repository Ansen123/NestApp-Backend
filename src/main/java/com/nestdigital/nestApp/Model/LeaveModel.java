package com.nestdigital.nestApp.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaves")

@Getter
@Setter
public class LeaveModel {
    @Id
    @GeneratedValue
    private int id;
    private int emp_id;
    private String applyDate;
    private String leaveDate;
    private int Status;

    public LeaveModel(int id, int emp_id, String applyDate, String leaveDate, int status) {
        this.id = id;
        this.emp_id = emp_id;
        this.applyDate = applyDate;
        this.leaveDate = leaveDate;
        Status = status;
    }

    public LeaveModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
