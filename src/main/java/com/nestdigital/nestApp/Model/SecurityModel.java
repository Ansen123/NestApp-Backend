package com.nestdigital.nestApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Security")
public class SecurityModel {
    @Id
    @GeneratedValue
    private int id;
    private int sCode;
    private String sName;
    private String sAdd;
    private String sPhone;
    private String sDate;

    private String sPassword;
    private String sUsername;

    public SecurityModel(int id, int sCode, String sName, String sAdd, String sPhone, String sDate, String sPassword, String sUsername) {
        this.id = id;
        this.sCode = sCode;
        this.sName = sName;
        this.sAdd = sAdd;
        this.sPhone = sPhone;
        this.sDate = sDate;
        this.sPassword = sPassword;
        this.sUsername = sUsername;
    }

    public SecurityModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getsCode() {
        return sCode;
    }

    public void setsCode(int sCode) {
        this.sCode = sCode;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAdd() {
        return sAdd;
    }

    public void setsAdd(String sAdd) {
        this.sAdd = sAdd;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsUsername() {
        return sUsername;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername;
    }
}
