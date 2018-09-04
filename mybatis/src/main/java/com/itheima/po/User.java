package com.itheima.po;

import java.util.Date;

public class User {
	private Integer id;
	private String username;
	private Date birthday;
	private String sex;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String name) {
		this.username = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", birthday=" + birthday + ", sex=" + sex + ", address=" + address
				+ "]";
	}
	
	
}
