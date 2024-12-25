package com.sathya.SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.SpringBoot.entity.ProductEntity;
import com.sathya.SpringBoot.model.ProductModel;
import com.sathya.SpringBoot.repository.ProductRepository;

@Service
public class ProductService
{
	@Autowired
	ProductRepository productRepository;
	//ProductEntity productEntity;
	
	public void saveproductdetails(ProductModel productModel)
	{
		double discountprice;
		discountprice=productModel.getPrice()*(productModel.getDiscountrate()/100);
		double offerprice;
		offerprice=productModel.getPrice()-discountprice;
		
		double finalprice;
		finalprice=productModel.getTaxprice()+offerprice;
		
		double stockvalue;
		stockvalue=productModel.getQuantity()*offerprice+productModel.getTaxprice()/100;
		
		ProductEntity productEntity=new ProductEntity();
		productEntity.setName(productModel.getName());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setMadeIn(productModel.getMadeIn());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setDiscountrate(productModel.getDiscountrate());
		productEntity.setTaxrate(productModel.getTaxprice());
		productEntity.setDiscountprice(discountprice);
		productEntity.setOfferprice(offerprice);
		productEntity.setFinalprice(finalprice);
		productEntity.setStockvalue(stockvalue);
		productRepository.save(productEntity);
		
		
	}
	
	public List<ProductEntity> getallproducts()
	{
		List<ProductEntity> products= productRepository.findAll();
		return products;
	}

	public ProductEntity searchProductById(Long id) {
		Optional<ProductEntity> optionaldata= productRepository.findById(id);
		if(optionaldata.isPresent())
		{
			ProductEntity product=optionaldata.get();
			return product;
		}
		else
		{
			return null;
		}
		
	}

	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
		
	}

	public ProductModel editById(Long id) {
		Optional<ProductEntity> optionaldata=productRepository.findById(id);
		if(optionaldata.isPresent())
		{
			ProductModel product=new ProductModel();
			ProductEntity eproduct=optionaldata.get();
			product.setName(eproduct.getName());
			product.setBrand(eproduct.getBrand());
			product.setMadeIn(eproduct.getMadeIn());
			product.setQuantity(eproduct.getQuantity());
			product.setPrice(eproduct.getPrice());
			product.setDiscountrate(eproduct.getDiscountrate());
			product.setTaxprice(eproduct.getTaxrate());
			return product;
		}
		else
		{
			return null;
		}
		
	}

	public void updateData(Long id, ProductModel productModel) 
	{
	Optional<ProductEntity>	optionaldata=productRepository.findById(id);
	if(optionaldata.isPresent())
	{
		ProductEntity entity =optionaldata.get();
		entity.setName(productModel.getName());
        entity.setBrand(productModel.getBrand());
        entity.setMadeIn(productModel.getMadeIn());
        entity.setPrice(productModel.getPrice());
        entity.setQuantity(productModel.getQuantity());
        entity.setDiscountrate(productModel.getDiscountrate());
        entity.setTaxrate(productModel.getTaxprice());
        double discountprice;
		discountprice=productModel.getPrice()*(productModel.getDiscountrate()/100);
		double offerprice;
		offerprice=productModel.getPrice()-discountprice;
		
		double finalprice;
		finalprice=productModel.getTaxprice()+offerprice;
		
		double stockvalue;
		stockvalue=productModel.getQuantity()*offerprice+productModel.getTaxprice()/100;
		entity.setDiscountprice(discountprice);
		entity.setOfferprice(offerprice);
		entity.setFinalprice(finalprice);
		entity.setStockvalue(stockvalue);
		productRepository.save(entity);
	}

		
	}


	
	

}
