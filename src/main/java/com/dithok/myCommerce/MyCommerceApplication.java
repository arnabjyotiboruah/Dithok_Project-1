package com.dithok.myCommerce;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.AuditorAware;
import com.dithok.myCommerce.audit.AuditorAwareImpl;

//The start point of the spring boot applicaiton
@SpringBootApplication()
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Controller
public class MyCommerceApplication {


@Autowired
HttpServletRequest request;

@Bean
public AuditorAware<String> auditorAware() {
	return new AuditorAwareImpl();
}

public static void main(String[] args) {
	SpringApplication.run(MyCommerceApplication.class, args);
	

}

@GetMapping("/")	
public String start(){
	if(request.getSession(false)!=null){
		return "redirect:/index";
	}
	else 
	{
		return "login";
	}	
}

@GetMapping("/alluserDetails")	
public String allUser(){
	if(request.getSession(false)!=null){
		return "alluserDetails";
	}
	else 
	{
		return "redirect:/";
	}
}

@GetMapping("/auditLogDetails")	
public String auditLogDetails(){
	if(request.getSession(false)!=null){
		return "auditLogDetails";
	}
	else 
	{
		return "redirect:/";
	}
}

@GetMapping("/searchEditUser")	
public String searchEditUser(){
	if(request.getSession(false)!=null){
		return "searchEditUser";
	}
	else 
	{
		return "redirect:/";
	}
}


@GetMapping("/index")
public String index(){
	if(request.getSession(false)!=null)
	{
		return "index";
	}
	else 
	return "redirect:/";
}


@GetMapping("/settings")
public String setting()
{
	if(request.getSession(false)!=null)
	{
		return "settings";
	}
	else
	return "redirect:/";

}
@GetMapping("/editUser")
public String editUser(@RequestParam String phone)
{
	if(request.getSession(false)!=null)
	{
		return "editUser";
	}
	else
	return "redirect:/";

}



}
