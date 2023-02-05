package com.my.app.app1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.app.app1.dto.UserDto;
import com.my.app.app1.dto.UserEtcDto;
import com.my.app.app1.service.App1Service;

import io.swagger.annotations.ApiOperation;

@Controller
public class App1Controller {
	
	@Autowired
	private App1Service app1Service;

	@ApiOperation(value = "사용자 목록 조회")
	@GetMapping("/api/users")
	@ResponseBody
	public List<UserDto> retrieveApiUsers() {
		return app1Service.retrieveUsers();
	}

	@GetMapping("/api/user-etcs")
	@ResponseBody
	public List<UserEtcDto> retrieveApiUserEtcs() {
		return app1Service.retrieveUserEtcs();
	}
	
	@ApiOperation(value = "사용자 저장(신규, 수정)")
	@PostMapping("/api/users")
	@ResponseBody
	public UserDto saveApiUsers(UserDto userDto) {
		return app1Service.saveUser(userDto);
	}
	
	@GetMapping("/listUser")
	public String retrieveUserList(ModelMap model) {
		List<UserDto> userDtoList = app1Service.retrieveUsers();
		model.addAttribute("userDtoList", userDtoList);
		return "app1/list";
	}

	@GetMapping("/saveUserForm")
	public String saveUserForm(ModelMap model, UserDto userDto) {
		return "app1/form";
	}

	@PostMapping("/saveUser")
	public String saveUser(UserDto userDto) {
		app1Service.saveUser(userDto);
		return "redirect:/listUser";
	}
	
}
