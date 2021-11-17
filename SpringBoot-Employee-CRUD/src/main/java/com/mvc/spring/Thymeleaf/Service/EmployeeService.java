package com.mvc.spring.Thymeleaf.Service;

import java.util.List;

import com.mvc.spring.Thymeleaf.entity.Employee;



public interface EmployeeService {

	public List<Employee> getEmployees();
	
	public Employee getEmployees(int id);
	
	public void save(Employee employee);
	
	public void delete(int id);
}
