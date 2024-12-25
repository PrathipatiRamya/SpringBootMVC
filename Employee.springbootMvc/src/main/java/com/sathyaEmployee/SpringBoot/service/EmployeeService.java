package com.sathyaEmployee.SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathyaEmployee.SpringBoot.entity.EmployeeEntity;
import com.sathyaEmployee.SpringBoot.model.EmployeeModel;
import com.sathyaEmployee.SpringBoot.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepository employeeRepository;

	public void saveemployeedetails(EmployeeModel employeeModel)
	{
		double allowance;
		double bonous;
		double mediaclinsurance;
		double basicsalary;
		double monthlysalary;
		
		if(employeeModel.getGrosssalary()<=350000)
		{
			bonous=10000;
			allowance=2000;
			mediaclinsurance=3000;
			basicsalary=employeeModel.getGrosssalary()-bonous-allowance-mediaclinsurance;
		}
		else if(employeeModel.getGrosssalary()>350000 && employeeModel.getGrosssalary()<1000000)
		{
			bonous=60000;
			allowance=4000;
			mediaclinsurance=50000;
			basicsalary=employeeModel.getGrosssalary()-bonous-allowance-mediaclinsurance;
			
		}
		else
		{
			bonous=100000;
			allowance=7000;
			mediaclinsurance=70000;
			basicsalary=employeeModel.getGrosssalary()-bonous-allowance-mediaclinsurance;
		}
		
		monthlysalary=(int)employeeModel.getGrosssalary()/12;
		EmployeeEntity employeeEntity=new EmployeeEntity();
		employeeEntity.setName(employeeModel.getName());
		employeeEntity.setDepartment(employeeModel.getDepartment());
		employeeEntity.setAge(employeeModel.getAge());
		employeeEntity.setGrosssalary(employeeModel.getGrosssalary());
		employeeEntity.setLocation(employeeModel.getLocation());
		employeeEntity.setGender(employeeModel.getGender());
		employeeEntity.setMonthlysalary(monthlysalary);
		employeeEntity.setBasicsalary(basicsalary);
		employeeEntity.setAllowance(allowance);
		employeeEntity.setBonous(bonous);
		employeeEntity.setMedicalinsurance(mediaclinsurance);
		employeeRepository.save(employeeEntity);
		
	}

	public List<EmployeeEntity> allEmployeeDetails() 
	{
			
	   List<EmployeeEntity> employess=employeeRepository.findAll();
	   return employess;
		
	}

	public EmployeeEntity searchEmployeeById(Long id) {
		Optional<EmployeeEntity> optionaldata =employeeRepository.findById(id);
		if(optionaldata.isPresent())
		{
			EmployeeEntity employee=optionaldata.get();
			return employee;
		}
		else
		{
			return null;
		}
		
	}

	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		
	}

	public EmployeeModel editEmployeeById(Long id)
	{
	Optional<EmployeeEntity> optionaldata=employeeRepository.findById(id);
	if(optionaldata.isPresent())
	{
		EmployeeEntity eemployee=optionaldata.get();
		EmployeeModel employee =new EmployeeModel();
		employee.setName(eemployee.getName());
		employee.setDepartment(eemployee.getDepartment());
		employee.setAge(eemployee.getAge());
		employee.setGender(eemployee.getGender());
		employee.setLocation(eemployee.getLocation());
		employee.setGrosssalary(eemployee.getGrosssalary());
		return employee;
		
	}
	else
	{
		return null;
	}
		
	}

	public void updateEmployeeDetails(Long id, EmployeeModel employeeModel) 
	{
	  Optional<EmployeeEntity> optionaldata=employeeRepository.findById(id);
	  if(optionaldata.isPresent())
	  {
		  EmployeeEntity employeeEntity=optionaldata.get();
		  double allowance;
			double bonous;
			double mediaclinsurance;
			double basicsalary;
			double monthlysalary;
			
			if(employeeModel.getGrosssalary()<=350000)
			{
				bonous=10000;
				allowance=2000;
				mediaclinsurance=3000;
				basicsalary=employeeModel.getGrosssalary()-bonous-allowance-mediaclinsurance;
			}
			else if(employeeModel.getGrosssalary()>350000 && employeeModel.getGrosssalary()<1000000)
			{
				bonous=60000;
				allowance=4000;
				mediaclinsurance=50000;
				basicsalary=employeeModel.getGrosssalary()-bonous-allowance-mediaclinsurance;
				
			}
			else
			{
				bonous=100000;
				allowance=7000;
				mediaclinsurance=70000;
				basicsalary=employeeModel.getGrosssalary()-bonous-allowance-mediaclinsurance;
			}
			
			monthlysalary=(int)employeeModel.getGrosssalary()/12;
			employeeEntity.setName(employeeModel.getName());
			employeeEntity.setDepartment(employeeModel.getDepartment());
			employeeEntity.setAge(employeeModel.getAge());
			employeeEntity.setGrosssalary(employeeModel.getGrosssalary());
			employeeEntity.setLocation(employeeModel.getLocation());
			employeeEntity.setGender(employeeModel.getGender());
			employeeEntity.setMonthlysalary(monthlysalary);
			employeeEntity.setBasicsalary(basicsalary);
			employeeEntity.setAllowance(allowance);
			employeeEntity.setBonous(bonous);
			employeeEntity.setMedicalinsurance(mediaclinsurance);
			employeeRepository.save(employeeEntity);
			 
	  }
		
	}
	

}
