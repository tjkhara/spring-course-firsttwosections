package com.jrp.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {

	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public String sayHello() {
		return "<h2>hello</h2>";
	}
	
	@RequestMapping(value = "/proper", method = RequestMethod.GET)
	public String sayProperHello() {
		return "<h2>hello there how are you</h2>";
	}
	
	@RequestMapping("/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\" method=\"GET\">\r\n" + 
		"  First name:<br>\r\n" + 
		"  <input type=\"text\" name=\"firstname\">\r\n" + 
		"  <br>\r\n" + 
		"  Last name:<br>\r\n" + 
		"  <input type=\"text\" name=\"lastname\">\r\n" + 
		"  <br><br>\r\n" + 
		"  <input type=\"submit\" value=\"Submit\">\r\n" + 
		"</form> ";
	}
	
	@RequestMapping(value = "/user_greeting", method = RequestMethod.GET)
	public String printUserGreeting(@RequestParam String firstname,@RequestParam String lastname) {
		return "Hello there, " + firstname + " " + lastname;
	}
	
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order id: " + id;
	}
}
