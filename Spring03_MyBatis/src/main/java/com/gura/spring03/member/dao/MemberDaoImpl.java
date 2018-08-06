package com.gura.spring03.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring03.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	// 의존객체 자동 주입(Dependency Injection) 
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
	}

	@Override
	public MemberDto getData(int num) {
		return session.selectOne("member.getData", num);
	}

	@Override
	public List<MemberDto> getList() {
		return session.selectList("member.getList");
	}
}
