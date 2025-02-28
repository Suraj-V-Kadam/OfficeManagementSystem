package com.oms.officeManagement.contoller;

import com.oms.officeManagement.dto.EmployeeDto;
import com.oms.officeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.addEmployee(employeeDto);
    }

    @GetMapping("/get/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("get/all")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @PutMapping("update")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeDto);
    }
    @DeleteMapping("delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
