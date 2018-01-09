package com.akash.dao;

import java.util.List;

import com.akash.bean.Users;

public interface UserBO {
	public List<Users> getUsers();
	public Users getUser(int id);
	public int createUser(Users u);
	public int deleteUser(int id);
	public int updateUser(Users u);
}
