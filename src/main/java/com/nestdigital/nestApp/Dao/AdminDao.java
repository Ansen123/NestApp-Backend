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

}

