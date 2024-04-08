package com.react.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.react.model.Product;
import com.react.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository pr;
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return pr.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Product p=pr.findById(id).get();
		if(p!=null) {
			pr.delete(p);
			return "delete";
		}
		return "error";	
		
	}

	@Override
	public Product editProduct(Product Product, Integer id) {
		Product oldProduct=pr.findById(id).get();
		oldProduct.setProductName(Product.getProductName());
		oldProduct.setDescription(Product.getDescription());
		oldProduct.setPrice(Product.getPrice());
		oldProduct.setStatus(Product.getStatus());
		return pr.save(oldProduct);
	}

}
