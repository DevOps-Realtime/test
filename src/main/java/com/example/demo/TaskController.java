package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.gson.Gson;


@Controller
public class TaskController {
	
	
	@Autowired
	TaskService service;
	
	
	@RequestMapping("/")
	public String Index() {
		return "Index";
		
	}
	@RequestMapping("/Index")
	public String Home() {
		return "Index";
		
	}
	@RequestMapping("/About")
	public String Electronics() {
		return "About";
		
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String SaveRegister(Task t,Model model) {
		String s="select count(*) username from task1 where username=?";
		int count =1;
		//int count=jdbctemplate.queryForObject(s,new Object[] {t.getUsername()},Integer.class);
		if( count == 0) {
		
		String query="insert into task1(firstname,lastname,email,username,password,confirmpassword) values('"+t.getFirstname()+"','"+t.getLastname()+"','"+t.getEmail()+"','"+t.getUsername()+"','"+t.getPassword()+"','"+t.getConfirmpassword()+"')";
		//jdbctemplate.update(query);
	
		return "Index"; 
		}
		else {
			model.addAttribute("UserExists", "UserExists");
			return "Register"; 
		}
		
	}
	@RequestMapping(value = "/valid", method=RequestMethod.POST)
    public String username(Model md2,Task t,BindingResult result){
   

//		   md2.addAttribute("results2", service.usernameandpassword());
//		   
//		   Gson gson2 =new Gson();
//		   String res2=gson2.toJson(md2);
//		   
//		      JSONObject resultObject = new JSONObject(res2);
//           JSONArray JArray = resultObject.getJSONArray("results2");
//			
//
//			            for (int i=0; i<JArray.length(); i++) {
//
//			                      JSONObject JObject =JArray.getJSONObject(i);
//			                  
//			                       
//			                    if((JObject.get("username").equals(t.getUsername())) & (JObject.get("password").equals(t.getPassword()))) {
//			                	
//			                      return "Index";
//			                	    
//			                       }
//			                     else if((JObject.get("username")!=(t.getUsername())) & (JObject.get("password")!=(t.getPassword()))) {
//			                	 
//			                    	 md2.addAttribute("logError","logError");
//			                         return "About";
//			                	  
//			                  }
//			          }
		 return "About?error"; 
			
	}
	

	@Bean
	   public ViewResolver getViewResolver() {
	       InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	       resolver.setPrefix("templates/");
	       resolver.setSuffix(".html");
	       return resolver;
	   } 

}
