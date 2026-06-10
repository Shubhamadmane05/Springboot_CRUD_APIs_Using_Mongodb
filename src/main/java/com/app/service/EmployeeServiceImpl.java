package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;
import com.app.exception.ResourceNotFoundException;
import com.app.mapper.EmployeeMapper;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDto create(EmployeeDto dto) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.toEntity(dto);
		
		Employee saved = employeeRepository.save(employee);
		
		return EmployeeMapper.toDto(saved);
		
		
	}

	@Override
	public List<EmployeeDto> getAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll()
				.stream()
				.map(EmployeeMapper:: toDto)
				.collect(Collectors.toList());
		
	}

	@Override
	public EmployeeDto getByID(String id) {
		// TODO Auto-generated method stub
		Employee employee= employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		
		return EmployeeMapper.toDto(employee);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public EmployeeDto updateEmployee(String id, EmployeeDto dto) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee Not Found"));
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setPhone(dto.getPhone());
		employee.setGender(dto.getGender());
		
		
		Employee update = employeeRepository.save(employee);
		
		
		return EmployeeMapper.toDto(update);
	}

}
