package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class DemoRsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRsApplication.class, args);
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String get(){
		return "hello";
	}
	
	@RequestMapping(value="/put", method=RequestMethod.PUT)
	public String echoPut(@RequestBody(required = false) String body){
		return body;
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String echoPost(@RequestBody(required = false) String body){
		return body;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public String echoDelete(@RequestBody(required = false) String body){
		return body;
	}
}
