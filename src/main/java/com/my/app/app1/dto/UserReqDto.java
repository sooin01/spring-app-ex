package com.my.app.app1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserReqDto {
	
	private String userId;
	@ApiModelProperty(required = true)
	private String userName;
	private String createDt;
	private String updateDt;
	
}
