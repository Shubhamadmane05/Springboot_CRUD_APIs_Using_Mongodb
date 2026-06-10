package com.app.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
