package com.app.service;

import java.util.List;

import com.app.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto create(EmployeeDto dto);
	
	public List<EmployeeDto> getAll();
	
	public EmployeeDto getByID(String id);
	
	public void delete(String id);
	
	public EmployeeDto updateEmployee(String id, EmployeeDto dto);
}
