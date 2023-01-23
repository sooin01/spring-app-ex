package com.my.app.app1.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.app1.vo.UserVo;

@Service
public class App1Service {
	
	@Autowired
	private SqlSession sqlSession;

	public List<UserVo> retrieveUsers() {
		return sqlSession.selectList("tbUser.retrieveUsers");
	}
	
}
