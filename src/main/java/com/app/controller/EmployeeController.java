package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmployeeDto;
import com.app.service.EmployeeService;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/get")
	public String getMsg() {
		return "welcome to Club";
	}
	
	@PostMapping("/create")
	public EmployeeDto create(@RequestBody EmployeeDto dto) {
		return employeeService.create(dto);
	}
	
	@GetMapping("/getAllEmp")
	public List<EmployeeDto> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("/{id}")
	public EmployeeDto getById(@PathVariable String id) {
		return employeeService.getByID(id);
	}
	
	@PutMapping("/{id}")
	public EmployeeDto updateEmp(@PathVariable String id, @RequestBody EmployeeDto dto) {
		return employeeService.updateEmployee(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		employeeService.delete(id);
		return "Employee Delete Sunccesfully..";
	}
}
