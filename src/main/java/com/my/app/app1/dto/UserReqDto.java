package com.my.app.app1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserReqDto {
	
	@ApiModelProperty
	private String userId;
	@ApiModelProperty(required = true)
	private String userName;
	@ApiModelProperty
	private String createDt;
	@ApiModelProperty
	private String updateDt;
	
}
