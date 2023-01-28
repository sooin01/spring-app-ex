package com.my.app.app1.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.my.app.app1.domain.TbUser;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(source = "id", target = "userId")
	UserDto toUserDto(TbUser tbUser);

}
