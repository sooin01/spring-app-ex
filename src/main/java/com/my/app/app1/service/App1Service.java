package com.my.app.app1.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.app1.domain.TbUser;
import com.my.app.app1.repository.App1Repository;
import com.my.app.app1.vo.TbUserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class App1Service {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private App1Repository app1Repository;

	public List<TbUser> retrieveUsers() {
		return app1Repository.findAll();
	}
	
	public List<TbUserVo> retrieveUsers2() {
		return sqlSession.selectList("tbUser.retrieveUsers");
	}
	
}
