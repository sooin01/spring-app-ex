package com.my.app.app1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.app1.domain.TbUserEtc;
import com.my.app.app1.dto.UserDto;
import com.my.app.app1.service.App1Service;

@RestController
public class App1Controller {
	
	@Autowired
	private App1Service app1Service;

	@GetMapping({"/", "users"})
	public List<UserDto> retrieveUsers() {
		return app1Service.retrieveUsers();
	}

	@GetMapping("/useretcs")
	public List<TbUserEtc> retrieveUserEtcs() {
		return app1Service.retrieveUserEtcs();
	}
	
	@PostMapping("/users")
	public int createUsers() {
		return app1Service.createUsers();
	}
	
}
