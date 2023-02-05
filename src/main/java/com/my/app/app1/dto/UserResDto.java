package com.my.app.app1.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserResDto {
	
	private String userId;
	private String userName;
	private String createDt;
	private String updateDt;
	private List<UserEtcResDto> userEtcs;
	
}
