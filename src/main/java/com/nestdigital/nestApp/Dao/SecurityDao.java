package com.nestdigital.nestApp.Dao;

import com.nestdigital.nestApp.Model.AdminModel;
import com.nestdigital.nestApp.Model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {
    @Modifying
    @Query(value = "DELETE FROM `security` WHERE `s_code`=:s_code",nativeQuery = true)
    void deleteSecurity(Integer s_code);

    @Query(value = "SELECT `id`, `s_add`, `s_code`, `s_date`, `s_name`, `s_password`, `s_phone`, `s_username` FROM `security` WHERE `s_code`=:s_code",nativeQuery = true)
    List<SecurityModel> searchSecurity(Integer s_code);

    @Modifying
    @Query(value = "UPDATE `security` SET `s_add`=:s_add,`s_date`=:s_date,`s_name`=:s_name,`s_password`=:s_password,`s_phone`=:s_phone,`s_username`=:s_username WHERE `s_code`=:s_code",nativeQuery = true)
    void edit(String s_add,Integer s_code,String s_date,String s_name ,String s_password, String s_phone,String s_username);

    @Query(value="SELECT `id`, `s_add`, `s_code`, `s_date`, `s_name`, `s_password`, `s_phone`, `s_username` FROM `security` WHERE `s_username`=:s_username AND`s_password`=:s_password",nativeQuery = true)
    List<SecurityModel> SignupBySecurity(String s_username,String s_password);

}

