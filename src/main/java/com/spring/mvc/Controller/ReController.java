package com.spring.mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {
	
	
	@RequestMapping("/index")
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping("/one")
	public String one() {
		System.out.println("inside one method");
		return "redirect:/two";
	}
	
	@RequestMapping("/two")
	public String two() {
		System.out.println("inside two method");
		System.out.println("showing index page");
		return "index";
	}
	
	@RequestMapping("/google")
	public RedirectView google() {
		
		RedirectView rv = new RedirectView();
		rv.setUrl("https://www.google.com");
		
		return rv;
	}
	
	@RequestMapping("/home")
	public RedirectView homePage() {
		RedirectView rv = new RedirectView();
		rv.setUrl("index");
		return rv;
	}
}
