package com.sathya.SpringBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Table(name="Product")

@Entity
public class ProductEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String name;
    private String brand;
    private String madeIn;
    private double price;
    private int quantity;
    private double discountrate;
    private double taxrate;
    
    //additional fields add to database
    private double discountprice;
    private double offerprice;
    private double finalprice;
    private double stockvalue;
}
