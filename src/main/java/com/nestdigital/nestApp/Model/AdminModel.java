package com.nestdigital.nestApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empAdd")
public class AdminModel {
    @Id
    @GeneratedValue

    private int id;
    private String name;
    private int empCode;
    private String email;
    private String address;
    private String phoneNumber;
    private String joinDate;
    private String userName;
    private String password;
    private String dob;


    public AdminModel(int id, String name, int empCode, String email, String address, String phoneNumber, String joinDate, String userName, String password, String dob) {
        this.id = id;
        this.name = name;
        this.empCode = empCode;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.joinDate = joinDate;
        this.userName = userName;
        this.password = password;
        this.dob = dob;
    }

    public AdminModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
