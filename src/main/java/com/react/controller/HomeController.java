package com.react.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.react.model.Product;
import com.react.service.ProductService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {

	@Autowired
	private ProductService ps;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product){
		return new ResponseEntity<>(ps.saveProduct(product),HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<?> getAllProduct(){
		return new ResponseEntity<>(ps.getAllProducts(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id){
		return new ResponseEntity<>(ps.getProductById(id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id){
		return new ResponseEntity<>(ps.deleteProduct(id),HttpStatus.OK);
	}
	@PutMapping("/editProduct/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Product product,@PathVariable int id){
		return new ResponseEntity<>(ps.editProduct(product, id
				),HttpStatus.CREATED);
	}

}
