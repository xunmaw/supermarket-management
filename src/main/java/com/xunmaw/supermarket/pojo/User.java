package com.xunmaw.supermarket.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 功能说明
 */
@Component
@Data
public class User {
	private Integer id; //id
	@NotEmpty(message = "用户编码不能为空！")
	private String userCode; //用户编码
	@NotEmpty(message = "用户名称不能为空！")
	private String userName; //用户名称
	@NotEmpty(message = "密码不能为空！")
	@Size(min = 6, max = 20, message = "密码输入不符合规范，请重新输入")
	private String userPassword; //用户密码
	@Range(min = 1, max = 2)
	private Integer gender;  //性别
	@Past(message = "必须是过去的一个时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date birthday;  //出生日期
	@Pattern(regexp = "^[150[0-9]+]{11}", message = "{valid.tel}")
	private String phone;   //电话
	
	public User() {}
	
	public User(Integer id, String userCode, String userName, String userPassword, Integer gender, Date birthday, String phone, String address, Integer userRole, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate, Integer age, String userRoleName, Role role) {
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.age = age;
		this.userRoleName = userRoleName;
		this.role = role;
	}
	
	@NotEmpty(message = "地址不能为空！")
	private String address; //地址
	//	@NotNull(message="用户角色不能为空！")
	private Integer userRole;    //用户角色
	private Integer createdBy;   //创建者
	private Date creationDate; //创建时间
	private Integer modifyBy;     //更新者
	private Date modifyDate;   //更新时间
	private Integer age;//年龄
	private String userRoleName;    //用户角色名称
	private Role role;
	
	public void setAge(Integer age) {
		System.out.println(role);
		this.age = age;
	}
	
	public Role getRole() {
		System.out.println(role);
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getUserRoleName() {
		return userRoleName;
	}
	
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	
	public Integer getAge() {
		Date date = new Date();
		System.out.println("                  " + date);
		System.out.println(" b                 " + birthday);
		Integer age = date.getYear() - birthday.getYear();
		System.out.println("1111111111           " + age);
//			int age=36;
		return age;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserCode() {
		return userCode;
	}
	
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public Integer getGender() {
		return gender;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getUserRole() {
		return userRole;
	}
	
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	
	public Integer getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Integer getModifyBy() {
		return modifyBy;
	}
	
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
