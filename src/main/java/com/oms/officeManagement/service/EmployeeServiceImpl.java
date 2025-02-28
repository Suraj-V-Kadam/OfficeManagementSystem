package com.oms.officeManagement.service;

import com.oms.officeManagement.dto.EmployeeDto;
import com.oms.officeManagement.entity.Employee;
import com.oms.officeManagement.exception.CustomException;
import com.oms.officeManagement.mapper.EmployeeMapper;
import com.oms.officeManagement.repository.EmployeeRepository;
import com.oms.officeManagement.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(employee -> EmployeeMapper
                        .mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        long startTime = System.currentTimeMillis();
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Employee is not exist with given id " + id,
                        HttpStatus.BAD_REQUEST,
                        TimeUtils.getDuration(startTime)));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        long startTime = System.currentTimeMillis();
        Employee employee = employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new CustomException("Employee is not exist with given id " + employeeDto.getId(),
                        HttpStatus.BAD_REQUEST,
                        TimeUtils.getDuration(startTime)));
        Employee updatedEmployee = EmployeeMapper.updateEmployeeFromDto(employeeDto, employee);
        updatedEmployee = employeeRepository.save(updatedEmployee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public String deleteEmployee(Long id) {
        long startTime = System.currentTimeMillis();
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Employee is not exist with given id " + id,
                        HttpStatus.BAD_REQUEST,
                        TimeUtils.getDuration(startTime)));
        employeeRepository.delete(employee);
        return "Employee record has been deleted.";
    }


}
