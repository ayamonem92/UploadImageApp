package com.aya.spring.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aya.spring.web.daos.Image;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String Home(){
		
		
		
		//to define controller and mvc we will add spring bean config file by these steps:
			//1-so we open --->  images-servlet.xml bean file and add namespace ---> mvc ,context
			//2-in context add component-scan to know all beans in the package controller
			//<context:component-scan base-package="com.spring.web.controllers"></context:component-scan>
			//3-<mvc:annotation-driven></mvc:annotation-driven>
		
		
		//Here we would open home.jsp page but we first need to add prefix and suffix to this string ---????? 
			//how to do that by resolver
				//add this code
			//<bean id="jspViewResolver"
			//	class="org.springframework.web.servlet.view.InternalResourceViewResolver">
					//<property name="prefix" value="/WEB-INF/jsps/"></property>
					//<property name="suffix" value=".jsp"></property>
			//</bean>

		return "home";
	}
	
}
