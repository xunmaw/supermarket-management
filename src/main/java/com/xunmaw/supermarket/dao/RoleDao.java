package com.xunmaw.supermarket.dao;

import com.xunmaw.supermarket.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
 
	List<Role> getRoleList();
 
}
