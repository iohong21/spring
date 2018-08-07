package com.shong.spring03.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shong.spring03.user.dao.UserDao;
import com.shong.spring03.user.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Override
	public void insert(UserDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(UserDto dto) {
		dao.update(dto);
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	public UserDto getData(String id) {
		return dao.getData(id);
	}

	@Override
	public List<UserDto> getList() {
		return dao.getList();
	}

	@Override
	public String isExist(String id) {
		return dao.isExist(id);
	}

}
