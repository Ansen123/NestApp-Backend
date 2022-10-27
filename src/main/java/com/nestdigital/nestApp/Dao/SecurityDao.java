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

    @Query(value = "SELECT `id`, `s_add`, `s_code`, `s_date`, `s_name`, `s_phone` FROM `security` WHERE `s_code`=:s_code",nativeQuery = true)
    List<SecurityModel> searchSecurity(Integer s_code);


}
