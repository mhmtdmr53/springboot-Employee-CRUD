package com.mvc.spring.Thymeleaf.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.spring.Thymeleaf.entity.Employee;
import com.mvc.spring.Thymeleaf.repository.EmployeeRepository;


@Service
public class EmployeeImplService implements EmployeeService {

	
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	public EmployeeImplService(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getEmployees() {
		
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee getEmployees(int id) {
	
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee=null;
		
		if (result.isPresent()) {
			
			employee=result.get();
		}
		else {
			throw new RuntimeException("did not found employee id  "+ id);
		}
		return 	employee;
	}

	@Override
	public void save(Employee employee) {
		
		employeeRepository.save(employee);

	}

	@Override
	public void delete(int id) {
		
		employeeRepository.deleteById(id);

	}

}
