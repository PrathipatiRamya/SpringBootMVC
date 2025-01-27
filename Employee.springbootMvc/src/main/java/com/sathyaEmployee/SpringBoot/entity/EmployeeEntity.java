package com.sathyaEmployee.SpringBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Employee")

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class EmployeeEntity 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 private String name;
	 private String department;
	private int age;
	private double grosssalary;
	private String location;
	private String gender;
	
	//additional information
	private double monthlysalary;
	private double basicsalary;
	private double allowance;
	private double bonous;
	private double medicalinsurance;
	
	
}
