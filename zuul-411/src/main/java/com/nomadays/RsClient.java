package com.nomadays;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("rs")
public interface RsClient {

	@RequestMapping(method = RequestMethod.GET, value = "/get")
    String get();
	
	@RequestMapping(value="/put", method=RequestMethod.PUT)
	String put(@RequestBody String body);
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	String post(@RequestBody String body);
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	String delete(@RequestBody String body);
	
}
