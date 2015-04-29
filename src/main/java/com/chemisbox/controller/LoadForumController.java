package com.chemisbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoadForumController {

	@RequestMapping(value = {"/forum", "/forum/"})
	public String doLoadForum(){
		
		return "forum";
	}

	@RequestMapping(value = {"/question", "/question/"})
	public String doLoadQuestion(){
		
		return "viewQuestion";
	}
	
	@RequestMapping(value = {"/ask", "/ask/"})
	public String doLoadAskQuestion(){
		
		return "askQuestion";
	}
}