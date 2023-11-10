package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao mDao = new MemberDao();

	@Override
	public int insertMember(Member m) {
				
		SqlSession sqlsession = Template.getsqlSession();
		
		int result = mDao.insertMember(sqlsession, m);
		
		if (result > 0) {
			sqlsession.commit();
		}
		// 요청이 1개일때는 굳이 rollback 할 필요없음
		
		sqlsession.close();
		
		return result;
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member loginMember(Member m) {
		SqlSession sqlsession = Template.getsqlSession();
		
		Member loginUser = mDao.loginMember(sqlsession, m);
		sqlsession.close();
		return loginUser;
	
	}

}
