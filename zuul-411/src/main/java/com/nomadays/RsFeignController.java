package com.nomadays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/rs")
public class RsFeignController {
	
	@Autowired
	RsClient rsClient;
	
	@GetMapping
	public String get() {
		return rsClient.get();
	}
	
	@PostMapping
	public String post(@RequestBody String body) {
		return rsClient.post(body);
	}
	
	@PutMapping
	public String put(@RequestBody String body) {
		return rsClient.put(body);
	}
	
	@DeleteMapping
	public String delete(@RequestBody String body) {
		return rsClient.delete(body);
	}

}
