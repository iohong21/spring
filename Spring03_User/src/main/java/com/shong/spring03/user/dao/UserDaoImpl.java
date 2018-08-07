package com.shong.spring03.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shong.spring03.user.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(UserDto dto) {
		session.insert("user.insert", dto);
	}

	@Override
	public void update(UserDto dto) {
		session.update("user.update", dto);
	}

	@Override
	public void delete(String id) {
		session.delete("user.delete", id);
	}

	@Override
	public UserDto getData(String id) {
		return session.selectOne("user.getData", id);
	}

	@Override
	public List<UserDto> getList() {
		return session.selectList("user.getList");
	}
	
	@Override
	public String isExist(String id) {
		return session.selectOne("user.isExist", id);
	}
}
