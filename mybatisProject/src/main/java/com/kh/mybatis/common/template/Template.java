package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	// 마이바티스
	// 이게 JDBC템플릿을 대체함
	
	
	public static SqlSession getsqlSession() {
		
		// mybatis-config.xml => 파일 읽어들이기
		// 해당 DB와 접속된 SqlSession 객체 생성해서 반환하기
		SqlSession sqlSession = null;
		
		// SqlSession 생성하기 위해서는 => SqlsessionFactory 필요
		// SqlsessionFactory 생성하기 위해서는 => SqlsessionFactoryBuilder 필요
		
		
		// resources 파일로 자동으로 찾아감
		String resource = "/mybatis-config.xml";
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			// openSession(boolean flag) => flag : 자동커밋 여부 (true면 자동커밋 false면 수동커밋)
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
		

		
	}
}




