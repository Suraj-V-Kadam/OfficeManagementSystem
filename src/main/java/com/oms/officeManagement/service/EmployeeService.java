package com.oms.officeManagement.service;

import com.oms.officeManagement.dto.EmployeeDto;
import com.oms.officeManagement.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto addEmployee(EmployeeDto employeeDto);
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto getEmployeeById(Long id);
    public EmployeeDto updateEmployee(EmployeeDto employeeDto);
    public String deleteEmployee(Long id);


}
