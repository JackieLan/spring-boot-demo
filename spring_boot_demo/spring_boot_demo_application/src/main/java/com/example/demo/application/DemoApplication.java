package com.example.demo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.library.service.Service;
import com.example.demo.library.service.ServiceConfiguration;

@SpringBootApplication
@Import(ServiceConfiguration.class)
@RestController
public class DemoApplication {
	private final Service service;

	@Autowired
	public DemoApplication(Service service) {
		this.service = service;
	}

	// @GetMapping("/")
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		return service.message();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
