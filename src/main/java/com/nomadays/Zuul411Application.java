package com.nomadays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableZuulProxy
@Controller
public class Zuul411Application {

	public static void main(String[] args) {
		SpringApplication.run(Zuul411Application.class, args);
	}
	
	@RequestMapping
	public String index(){
		return "index";
	}
	
	
}
