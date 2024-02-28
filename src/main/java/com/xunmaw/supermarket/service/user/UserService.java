package com.xunmaw.supermarket.service.user;

import com.xunmaw.supermarket.pojo.User;

import java.util.List;

public interface UserService {
	boolean add(User user);
	
	User login(String userCode, String userPassword);
	
	List<User> getUserList(String queryUserCode, int queryUserRole, int currentPageNo, int pageSize);
	
	int getUserCount(String queryUserName, int queryUserRole);
	
	User selectUserCodeExist(String userCode);
	
	boolean deleteUserById(Integer delId);
	
	User getUserById(String id);
	
	boolean modify(User user);
	
	boolean updatePwd(int id, String pwd);
}
