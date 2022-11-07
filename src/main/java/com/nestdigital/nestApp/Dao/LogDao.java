package com.nestdigital.nestApp.Dao;

import com.nestdigital.nestApp.Model.LogModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<LogModel,Integer> {

    @Modifying
    @Query(value = "UPDATE `log` SET `logout_sec_id`= :logout_sec_id,`logout_time`= :logout_time WHERE `emp_id`= :emp_id",nativeQuery = true)
    void Checkout(Integer logout_sec_id,String logout_time,Integer emp_id);


    @Query(value = "SELECT l.`login_sec_id`, l.`login_time`, l.`logout_sec_id`, l.`logout_time`,e.e_name FROM `log` l JOIN employee_tb e ON l.emp_id=e.emp_id",nativeQuery = true)
    List<Map<String,String>> viewallLogs();

    @Query(value = "SELECT l.`login_sec_id`, l.`login_time`, l.`logout_sec_id`, l.`logout_time`,e.e_name FROM `log` l JOIN employee_tb e ON l.emp_id=e.emp_id WHERE l.emp_id=:emp_id",nativeQuery = true)
    List<Map<String,String>> ViewByIdLogs(Integer emp_id);
}
