package com.my.app.app1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.app.app1.domain.TbUser;
import com.my.app.app1.dto.UserDto;
import com.my.app.app1.dto.UserEtcDto;
import com.my.app.app1.service.App1Service;

@Controller
public class App1Controller {
	
	@Autowired
	private App1Service app1Service;

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
	
	@PostMapping("/api/users")
	@ResponseBody
	public TbUser saveApiUsers(UserDto userDto) {
		return app1Service.saveUsers(userDto);
	}
	
	@GetMapping("/users")
	public String retrieveUserList(ModelMap model, UserDto userDto) {
		List<UserDto> userDtoList = app1Service.retrieveUsers();
		model.addAttribute("userDtoList", userDtoList);
		return "app1/index";
	}

	@PostMapping("/users")
	public String saveUsers(UserDto userDto) {
		app1Service.saveUsers(userDto);
		return "redirect:/users";
	}
	
}
