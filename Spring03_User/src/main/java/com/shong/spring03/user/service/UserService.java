package com.shong.spring03.user.service;

import java.util.List;

import com.shong.spring03.user.dto.UserDto;

public interface UserService {
	public void insert(UserDto dto);
	public void update(UserDto dto);
	public void delete(String id);
	public UserDto getData(String id);
	public List<UserDto> getList();
	public String isExist(String id);
}
