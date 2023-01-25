package com.my.app.app1.domain;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUser {
	
	@Id
	private String userId;
	private String userName;
	private String createDt;
	private String updateDt;
	
}
