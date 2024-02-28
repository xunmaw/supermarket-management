package com.xunmaw.supermarket.dao;

import com.xunmaw.supermarket.pojo.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Repository
public interface UsersDao {
	int countUser();
	
	List<User> getAllUser();
	
	User getUserById(String id);
	
	int add(User user);
	
	User getLoginUser(String userCode);
	
	User getLoginUser(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
	
	List<User> getUserList(@Param("userCode") String userName, @Param("userRole") int userRole, @Param("currentPageNo") int currentPageNo, @Param("pageSize") int pageSize);
	
	int getUserCount(@Param("userName") String userName, @Param("userRole") int userRole);
	
	int deleteUserById(Integer delId);
	
	int modify(User user);
	
    int updatePwd(@Param("id") int id, @Param("pwd") String pwd);
}
