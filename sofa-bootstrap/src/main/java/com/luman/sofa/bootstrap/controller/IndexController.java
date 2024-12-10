package com.luman.sofa.bootstrap.controller;

import com.luman.sofa.bootstrap.config.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {

	private final AppConfig appConfig;

	@RequestMapping("/")
	public String getById() {
		return appConfig.getApplicationName() + " is running";
	}
}
