package com.nestdigital.nestApp.Dao;

import com.nestdigital.nestApp.Model.SecurityModel;
import org.springframework.data.repository.CrudRepository;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {
}
