package com.gura.spring03.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring03.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(MemberDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDto getData(int num) {
		return session.selectOne("member.getData", 1);
	}

	@Override
	public List<MemberDto> getList() {
		//List<MemberDto> list = session.selectList("member.getList");
		//return list;
		return session.selectList("member.getList");
	}
}
