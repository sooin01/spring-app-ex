package com.my.app.app1.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDto {
	
	private String userId;
	private String userName;
	private Date createDt;
	private Date updateDt;
	
}
