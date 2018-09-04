package com.itheima.mapper;

import com.itheima.po.User;

public interface UserMapper {
	User queryUserById(Integer id);
	void inserUser(User user);
}
