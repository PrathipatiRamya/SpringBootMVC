package com.sathyaEmployee.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathyaEmployee.SpringBoot.entity.EmployeeEntity;
import com.sathyaEmployee.SpringBoot.model.EmployeeModel;
import com.sathyaEmployee.SpringBoot.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employeeform")
	public String empform()
	{
		return "add-employee";
	}
	
	
	
    @PostMapping("/saveemployee")
    public String employeeSaved(EmployeeModel employeeModel)
    {
    	System.out.println(employeeModel);
    	employeeService.saveemployeedetails(employeeModel);
    	return "redirect:/getallemployeedetails";
    }
    
    
    @GetMapping("/getallemployeedetails")
    public String employeeDetails(Model model)
    {
    	List<EmployeeEntity> employees=employeeService.allEmployeeDetails();
    	model.addAttribute("employees", employees); 	
    	return "all-employee-details";
    }
    
    @GetMapping("/searchform")
    public String SerachEmployee()
    {
    	return "search-employee";
    }
    
    @PostMapping("/searchbyid")
    public String searchEmployeeById(@RequestParam Long id,Model model)
    {
    	EmployeeEntity employee =employeeService.searchEmployeeById(id);
    	model.addAttribute("employee", employee);
    	return "search-employee";
    }
    
    @GetMapping("/delete")
    public String deleteEmployeeById(@RequestParam("id") Long id)
    {
    	employeeService.deleteEmployeeById(id);
    	return "redirect:/getallemployeedetails";
    }
 
    @GetMapping("/edit")
    public String editEmployeeById(@RequestParam Long id,Model model)
    {
    	EmployeeModel employee=employeeService.editEmployeeById(id);
    	model.addAttribute("employee", employee);
    	model.addAttribute("id", id);
    	return "edit-employee-form";
    }
    
    @PostMapping("/saveeditemployee")
    public String updateEmployeeDetails(@RequestParam("id") Long id,EmployeeModel employeeModel)
    {
    	employeeService.updateEmployeeDetails(id,employeeModel);
    	return "redirect:/getallemployeedetails";
    }
}
