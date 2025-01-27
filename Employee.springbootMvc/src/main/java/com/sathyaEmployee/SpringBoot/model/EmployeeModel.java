package com.sathyaEmployee.SpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel
{

	private String name;
	private String department;
	private int age;
	private double grosssalary;
	private String location;
	private String gender;
	
}
