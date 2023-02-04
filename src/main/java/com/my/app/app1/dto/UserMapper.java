package com.my.app.app1.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.my.app.app1.domain.TbUser;
import com.my.app.app1.domain.TbUserEtc;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(source = "id", target = "userId")
	@Mapping(target = "createDt", dateFormat = "yyyy-MM-dd")
	@Mapping(target = "updateDt", dateFormat = "yyyy-MM-dd")
	@Mapping(source = "tbUserEtcs", target = "userEtcs")
	UserDto toUserDto(TbUser tbUser);

	@Mapping(source = "userId", target = "id")
	@Mapping(target = "createDt", dateFormat = "yyyy-MM-dd")
	@Mapping(target = "updateDt", dateFormat = "yyyy-MM-dd")
	@Mapping(target = "tbUserEtcs", ignore = true)
	TbUser toTbUser(UserDto userDto);

	@Mapping(source = "tbUserEtcId.id", target = "userId")
	@Mapping(source = "tbUserEtcId.userEtcSeq", target = "userEtcSeq")
	UserEtcDto toUserEtcDto(TbUserEtc tbUserEtc);
	
}
