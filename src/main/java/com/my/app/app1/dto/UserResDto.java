package com.my.app.app1.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserResDto {
	
	@ApiModelProperty
	private String userId;
	@ApiModelProperty(required = true)
	private String userName;
	@ApiModelProperty
	private String createDt;
	@ApiModelProperty
	private String updateDt;
	private List<UserEtcResDto> userEtcs;
	
}
