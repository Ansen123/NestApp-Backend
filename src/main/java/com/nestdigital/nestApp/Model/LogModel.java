package com.nestdigital.nestApp.Model;

import com.nestdigital.nestApp.Dao.LogDao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LogModel {
    @Id
    @GeneratedValue
    private int id;

}
