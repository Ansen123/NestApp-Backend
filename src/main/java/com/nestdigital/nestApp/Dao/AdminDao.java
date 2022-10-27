package com.nestdigital.nestApp.Dao;

import com.nestdigital.nestApp.Model.AdminModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminDao extends CrudRepository<AdminModel,Integer> {
    @Query(value = "SELECT * FROM `emp_add` WHERE `emp_code`=:emp_code",nativeQuery = true)
    List<AdminModel> searchEmp(Integer emp_code);


    @Modifying
    @Query(value = "DELETE FROM `emp_add` WHERE `emp_code`=:emp_code",nativeQuery = true)
    void deleteEmployeeByEmp_code(Integer emp_code);
    @Modifying
    @Query(value = "UPDATE `emp_add` SET `address`=:address,`email`=:email,`emp_code`=:emp_code,`name`=:name,`phone_number`=:phone_number,`dob`=:dob,`join_date`=:join_date,`password`=:password,`user_name`=:user_name WHERE `emp_code`=:emp_code",nativeQuery = true)
    void edit(String address,String email,String name,String phone_number,String dob,String join_date,String password,String user_name,Integer emp_code);
}

