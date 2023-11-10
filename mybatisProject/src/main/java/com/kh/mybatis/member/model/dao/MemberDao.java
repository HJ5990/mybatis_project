package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlsession, Member m) {
		int result = sqlsession.insert("memberMapper.insertMember", m);
		return result;
	}
	
	public Member loginMember(SqlSession sqlsession, Member m) {
		return sqlsession.selectOne("memberMapper.loginMember", m);
	}
	
	
	

}
