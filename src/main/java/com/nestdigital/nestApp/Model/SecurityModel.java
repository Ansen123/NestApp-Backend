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
@Table(name = "securities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SecurityModel {

    @Id
    @GeneratedValue

    public int id;
    public int sCode;
    public String sName;
    public String sPhn;
    public String sAddress;
    public String rDate;
    public String userName;
    public String pass;

}
