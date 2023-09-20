package com.backend.app.productos.models.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.productos.models.entity.Producto;
import com.backend.app.productos.models.service.ProductosService;

@RestController
public class ProductosController {
	
	@Autowired
	private ProductosService service;
	
	@GetMapping("/productos")
	public List<Producto> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
	    Optional<Producto> optionalProducto = service.findById(id);
	    if (!optionalProducto.isPresent()) {
	    	return new ResponseEntity<>("Producto no encontrado para ID: " + id, HttpStatus.NOT_FOUND);
	    }
	    
	    Producto currentProducto = optionalProducto.get();
	    return new ResponseEntity<>(currentProducto, HttpStatus.OK);
	}
	
	@DeleteMapping("/productos")
	public ResponseEntity<?> deleteAll() {
		service.deleteAll();
		return new ResponseEntity<>("Todos los productos eliminados.", HttpStatus.OK);
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
	    Optional<Producto> optionalProducto = service.findById(id);
	    if (!optionalProducto.isPresent()) {
	    	return new ResponseEntity<>("Producto no encontrado para ID: " + id, HttpStatus.NOT_FOUND);
	    }
	    
		service.deleteById(id);
		return new ResponseEntity<>("Producto eliminado para ID: " + id, HttpStatus.OK);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<Producto> create(@RequestBody Producto producto) {
		// Set current date and time
		producto.setAddedAt(new Date());
	    
	    Producto savedProducto = service.save(producto);
	    return new ResponseEntity<>(savedProducto, HttpStatus.CREATED);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Producto producto) {
	    Optional<Producto> optionalProducto = service.findById(id);
	    if (!optionalProducto.isPresent()) {
	    	return new ResponseEntity<>("Producto no encontrado para ID: " + id, HttpStatus.NOT_FOUND);
	    }
	    
	    Producto currentProducto = optionalProducto.get();
	    
	    // Only update provided parameters
	    if (producto.getName() != null && !producto.getName().isEmpty()) {
	        currentProducto.setName(producto.getName());
	    }
	    if (producto.getBrand() != null && !producto.getBrand().isEmpty()) {
	        currentProducto.setBrand(producto.getBrand());
	    }
	    if (producto.getStock() != null) {
	        currentProducto.setStock(producto.getStock());
	    }
	    
	    Producto updatedProducto = service.save(currentProducto);
	    return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
	}
}