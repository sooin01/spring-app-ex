package com.my.app.app1.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.app.app1.common.exception.BizException;
import com.my.app.app1.common.repository.TbUserEtcRepository;
import com.my.app.app1.common.repository.TbUserRepository;
import com.my.app.app1.domain.TbUser;
import com.my.app.app1.dto.UserEtcResDto;
import com.my.app.app1.dto.UserMapper;
import com.my.app.app1.dto.UserReqDto;
import com.my.app.app1.dto.UserResDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class App1Service {
	
	@Autowired
	private TbUserRepository tbUserRepository;

	@Autowired
	private TbUserEtcRepository tbUserEtcRepository;
	
	public List<UserResDto> retrieveUsers() {
		return tbUserRepository.findAll()
				.stream()
				.map(UserMapper.INSTANCE::toUserDto)
				.collect(Collectors.toList());
	}
	
	public UserResDto retrieveUser(UserReqDto userReqDto) {
		Optional<TbUser> tbUserOpt = tbUserRepository.findById(userReqDto.getUserId());
		
		if (tbUserOpt.isPresent()) {
			return UserMapper.INSTANCE.toUserDto(tbUserOpt.get());
		} else {
			throw new BizException("Not found " + userReqDto.getUserId());
		}
	}
	
	public List<UserEtcResDto> retrieveUserEtcs() {
		return tbUserEtcRepository.findAll()
				.stream()
				.map(UserMapper.INSTANCE::toUserEtcDto)
				.collect(Collectors.toList());
	}
	
	public UserResDto saveUser(UserReqDto userReqDto) {
		Optional<TbUser> tbUserOpt = tbUserRepository.findById(userReqDto.getUserId());
		
		if (tbUserOpt.isPresent()) {
			TbUser tbUser = UserMapper.INSTANCE.toTbUser(userReqDto);
			tbUser.setTbUserEtcs(tbUserOpt.get().getTbUserEtcs());
			return UserMapper.INSTANCE.toUserDto(tbUserRepository.save(tbUser));
		} else {
			TbUser tbUser = new TbUser();
			tbUser.setId(UUID.randomUUID().toString());
			tbUser.setUserName(userReqDto.getUserName());
			tbUser.setCreateDt(new Date());
			tbUser.setUpdateDt(new Date());
			return UserMapper.INSTANCE.toUserDto(tbUserRepository.save(tbUser));
		}
	}
	
	public UserResDto updateUser(UserReqDto userReqDto) {
		Optional<TbUser> tbUserOpt = tbUserRepository.findById(userReqDto.getUserId());
		
		if (tbUserOpt.isPresent()) {
			TbUser tbUser = tbUserOpt.get();
			tbUser.setId(UUID.randomUUID().toString());
			tbUser.setUserName("이름3");
			tbUser.setCreateDt(new Date());
			tbUser.setUpdateDt(new Date());
			return UserMapper.INSTANCE.toUserDto(tbUserRepository.save(tbUser));
		} else {
			throw new BizException("Not found " + userReqDto.getUserId());
		}
	}
	
}
