package com.mvc.spring.Thymeleaf.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.spring.Thymeleaf.Service.EmployeeService;
import com.mvc.spring.Thymeleaf.entity.Employee;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	// load employee data
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/list")
	public String listEmployees(Model model)
	{
		List<Employee> employees=employeeService.getEmployees();
		
		
		model.addAttribute("employees", employees);
		
		return "employees/list-employees";
		
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		// create model attribute to bind form data
		Employee employees=new Employee();
		model.addAttribute("employees",employees);
		
		return "/employees/employee-form-data";
		
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employees") Employee employees)
	{
		// save the employee
		
		employeeService.save(employees);
		
		// use a redirect to prevent duplicate submissions
		
		return "redirect:/employees/list";
		
	}
	@GetMapping("/showFormForUpdate")
	public String showForForUpdate(@RequestParam("employeesId") int id,Model model)
	{
		
		// get the employee from service
		
		Employee employee=employeeService.getEmployees(id);
		
		// set employee as a model attribute to pre-populated the form
		
		model.addAttribute("employees", employee);
		
		// send over to our form
		
		return "/employees/employee-form-data";
		
		
	}
	
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("employeesId") int id)
	{
		
		// get the employee from service
		
		employeeService.delete(id);
		
		// delete the employee
		
		return "redirect:/employees/list";
		
		
	}
	
	
	
	
	
	
	
	
	

}
