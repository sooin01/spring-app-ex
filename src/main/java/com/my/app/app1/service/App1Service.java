package com.my.app.app1.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.app.app1.common.repository.TbUserRepository;
import com.my.app.app1.domain.TbUser;
import com.my.app.app1.vo.TbUserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class App1Service {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private TbUserRepository tbUserRepository;

	public List<TbUser> retrieveUsers() {
		return tbUserRepository.findAll();
	}
	
	public List<TbUserVo> retrieveUsers2() {
		return sqlSession.selectList("tbUser.retrieveUsers");
	}
	
	public int createUsers() {
		Optional<TbUser> tbUserOptional = tbUserRepository.findById("1406f810-b1da-4143-8a93-4af39dcf2585");
		
		if (tbUserOptional.isPresent()) {
			TbUser tbUser = tbUserOptional.get();
			tbUser.setId("1406f810-b1da-4143-8a93-4af39dcf2585");
			tbUser.setUserName("이름3");
			tbUser.setCreateDt(new Date());
			tbUser.setUpdateDt(new Date());
			tbUserRepository.save(tbUser);
			return 1;
		}
		
		return 0;
	}
	
}
