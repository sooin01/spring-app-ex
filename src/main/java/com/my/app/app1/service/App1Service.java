package com.my.app.app1.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.app1.dao.App1Dao;
import com.my.app.app1.domain.TbUser;
import com.my.app.app1.vo.TbUserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class App1Service {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private App1Dao app1Dao;

	public List<TbUserVo> retrieveUsers() {
		for (TbUser tbUser : app1Dao.findAll()) {
			log.info("{}", tbUser);
		}
		return sqlSession.selectList("tbUser.retrieveUsers");
	}
	
}
