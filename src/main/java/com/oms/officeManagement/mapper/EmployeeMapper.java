package com.oms.officeManagement.mapper;

import com.oms.officeManagement.dto.EmployeeDto;
import com.oms.officeManagement.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getEmailId(),
                employee.getMobileNumber()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getAge(),
                employeeDto.getEmailId(),
                employeeDto.getMobileNumber()
        );
    }
    public static Employee updateEmployeeFromDto(EmployeeDto dto, Employee existingEmployee) {
        if (dto.getName() != null) existingEmployee.setName(dto.getName());
        if (dto.getAge() != null) existingEmployee.setAge(dto.getAge());
        if (dto.getEmailId() != null) existingEmployee.setEmailId(dto.getEmailId());
        if (dto.getMobileNumber() != null) existingEmployee.setMobileNumber(dto.getMobileNumber());

        return existingEmployee;
    }
}
