 package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Student;
import com.cjc.main.service.HomeService;

@RestController
public class HomeController {
	@Autowired
	HomeService hs;
	//All data
	@RequestMapping(value="/getAllData",method=RequestMethod.GET)
	public Iterable<Student> loginPage(Model m)
	{

	  Iterable<Student> al=hs.displayData();  
	    
			return al;		
		}
	//Single Data 
	@RequestMapping(value="/login/{uname}/{password}",method=RequestMethod.GET)
	public Student loginPage(@PathVariable("uname") String un,@PathVariable("password") String ps)
	{
		Student s=hs.logincheck(un, ps);
	   return s;
	}	
			
			@RequestMapping("/reg")
	public String regData(@RequestBody Student s)
	{hs.saveData(s); 
	return "Success";
	}
	
	@RequestMapping(value="/delete/{uid}",method = RequestMethod.DELETE)
	public Iterable<Student> deletePage(@PathVariable("uid") int uid)
	{
		hs.deleteData(uid);
	    Iterable<Student> itr=hs.displayData();
	    		
		return itr;
	}
	@RequestMapping(value="update/{uid}",method = RequestMethod.PUT)
	public Iterable<Student> updatePage(@PathVariable("uid")int uid,@RequestBody Student s)
	{
		System.out.println(s.getName());
		System.out.println(s.getUid());
		System.out.println(uid);
	      hs.saveData(s);
		    Iterable<Student> itr=hs.displayData();
		    	
			return itr;
		}
	@RequestMapping(value="/regProducedata",method=RequestMethod.POST)
	public String postData(@RequestBody Student s)
	{hs.saveData(s);
	System.out.println(s.getName());
	
	return "ProduceSuccess";

	}	
	}




