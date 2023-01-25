package com.my.app.app1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.app1.domain.TbUser;
import com.my.app.app1.service.App1Service;

@RestController
public class App1Controller {
	
	@Autowired
	private App1Service app1Service;

	@GetMapping("/")
	public List<TbUser> index() {
		return app1Service.retrieveUsers();
	}
	
}
