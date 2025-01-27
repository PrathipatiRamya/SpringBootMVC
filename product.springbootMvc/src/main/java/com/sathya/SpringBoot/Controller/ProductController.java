package com.sathya.SpringBoot.Controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.SpringBoot.entity.ProductEntity;
import com.sathya.SpringBoot.model.ProductModel;
import com.sathya.SpringBoot.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController
{
@Autowired
ProductService productService;

 @GetMapping("/productform")
 public String productForm()
 {
	 return "add-product";
 }

 @GetMapping("/productform2")
 public String addProductWithDefaultValues(Model model)
 {
	 ProductModel productModel=new ProductModel();
	 productModel.setMadeIn("India");
	 productModel.setQuantity(2);
	 productModel.setDiscountrate(10.5);
	 model.addAttribute("productModel", productModel);
	 return "add-product-with-defaultvalues";
 }
 
 @PostMapping("/saveproduct")
 public String SaveProduct(@Valid ProductModel productModel,BindingResult bindingResult,Model model)
 {
	 HashMap<String, String> validationErrors=new HashMap<String,String>();
	 if(bindingResult.hasErrors())
	 {
		 for(FieldError fieldError :bindingResult.getFieldErrors())
		 {
			 validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		 }
		 model.addAttribute("validationErrors", validationErrors);
		 return "add-product-with-defaultvalues";
	 } 
	 
	 productService.saveproductdetails(productModel);
	 return "redirect:/getallproducts";
 }
 
 @GetMapping("/getallproducts")
 public String getAllProducts(Model model)
 {
	 List<ProductEntity> products=productService.getallproducts();
	 model.addAttribute("products",products);
	 return "all-products";
 }
 
 @GetMapping("/searchproduct")
 public String searchproduct() 
 {
	 return "search-product";
 }
 
 @PostMapping("/searchbyid")
public String searchProductById(@RequestParam Long id,Model model)
{
	ProductEntity product= productService.searchProductById(id);
	model.addAttribute("product",product);
	
	return "search-product";
}
 
 
 @GetMapping("/delete/{id}")
 public String deleteProductById(@PathVariable Long id)
 {
	 productService.deleteProductById(id);
	 return "redirect:/getallproducts";
	 
 }
 
 @GetMapping("/edit/{id}")
 public String editById(@PathVariable Long id,Model model)
 {
	 ProductModel product=productService.editById(id);
	 model.addAttribute("product", product);
	 model.addAttribute("id", id);
	 return "edit-product-form";
 }
 
 @PostMapping("/saveeditproduct/{id}")
 public String updateData(@PathVariable Long id,ProductModel productModel)
 {
	 productService.updateData(id,productModel);
	 return "redirect:/getallproducts";
 }
}
