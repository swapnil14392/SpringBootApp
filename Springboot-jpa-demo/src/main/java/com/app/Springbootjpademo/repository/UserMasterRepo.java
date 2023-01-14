package com.app.Springbootjpademo.repository;

import java.util.List;

import jakarta.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import com.app.Springbootjpademo.entity.UserMaster;

public interface UserMasterRepo extends CrudRepository<UserMaster, Long> {
	@QueryHints({@QueryHint(name=org.hibernate.annotations.QueryHints.CACHEABLE,value = "true")})
	List<UserMaster> findByUserNameOrderBySrNo(String username);
	
	@QueryHints({@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE,value = "true")})
	List<UserMaster> findAllByOrderBySrNo();
}
