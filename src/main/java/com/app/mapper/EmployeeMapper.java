package com.app.mapper;

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;

public class EmployeeMapper {

	
	public static Employee toEntity(EmployeeDto dto) {
		
		Employee employee = new Employee();
		employee.setId(dto.getId());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setPhone(dto.getPhone());
		employee.setGender(dto.getGender());
		
		return employee;
	}
	
	public static EmployeeDto toDto(Employee employee) {

	    EmployeeDto dto = new EmployeeDto();
	    dto.setId(employee.getId());
	    dto.setFirstName(employee.getFirstName());
	    dto.setLastName(employee.getLastName());
	    dto.setPhone(employee.getPhone());
	    dto.setGender(employee.getGender());

	    return dto;
	}
}
