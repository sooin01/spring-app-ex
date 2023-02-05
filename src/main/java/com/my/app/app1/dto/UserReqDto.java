package com.my.app.app1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserReqDto {
	
	private String userId;
	@ApiModelProperty(required = true)
	private String userName;
	@ApiModelProperty(value = "생성날짜(yyyy-MM-dd)")
	private String createDt;
	private String updateDt;
	
}
