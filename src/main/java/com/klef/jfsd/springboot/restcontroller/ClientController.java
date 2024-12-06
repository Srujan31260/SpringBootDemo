package com.klef.jfsd.springboot.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("rest")
public class ClientController 
{
	//collection
	List<Student> students = new ArrayList<Student>();
	@RequestMapping(path = "/",method = RequestMethod.GET)
	public String demo()
	{
		return "Hi Spring Boot";
	}
	@RequestMapping(path="/demo1")  //GET is by default method
	public String demo1 ()
	{
		return "Unknown Error";
	}
	@GetMapping("demo2")
	public String demo2()
	{
		return "Page Not Found";
	}
	@GetMapping("demo3")
	public long demo3()
	{
		return 260;
	}
	@GetMapping("demo4")
	public double demo4()
	{
		return 25000.50;
	}
	
	//passing parameters to the URL 
	
	@GetMapping("demo5")
	public String demo5(@RequestParam("id") int eid)
	{
		return "Employee ID:"+eid;
		
	}
	@GetMapping("demo6")
	public String demo6(@RequestParam("a") int x,@RequestParam("b") int y)
	{
		int z = x+y;
		return Integer.toString(z);	
	}
	@GetMapping("demo7/{id}")
	public String demo7(@PathVariable("id") int eid)
	{
		return "Employee ID:"+eid;	
	}
	@GetMapping("demo8/{a}/{b}")
	public String demo8(@PathVariable("a") int x ,@PathVariable("b") int y)
	{
		int z = x+y;
		return Integer.toString(z);	
	}
	
	@PostMapping("addstudent")
	public String addstudent(@RequestBody  Student s)
	{
		students.add(s);
		return "Student Addede succesfully";
	}
	
	@GetMapping("viewallstudents")
	public List<Student> viewallstudents()
	{
		return students;
	}
	
	@GetMapping("studentcount")
	public String studentcount()
	{
		if(students.size()!=0)
		{
			int count = students.size();
			return Integer.toString(count);
		}
		else
		{
			return "Student Data Not Found";
		}
		
	}

}
