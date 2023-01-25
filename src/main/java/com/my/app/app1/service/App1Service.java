package com.my.app.app1.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
	
	public int createUsers() {
		TbUser tbUser = new TbUser();
		tbUser.setUserId(UUID.randomUUID().toString());
		tbUser.setUserName("이름3");
		tbUser.setCreateDt(new Date());
		tbUser.setUpdateDt(new Date());
		app1Repository.save(tbUser);
		return 1;
	}
	
}
