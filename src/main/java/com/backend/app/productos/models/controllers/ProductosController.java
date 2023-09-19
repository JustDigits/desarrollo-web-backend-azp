package com.backend.app.productos.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.productos.models.entity.Producto;
import com.backend.app.productos.models.service.ProductosService;

@RestController
public class ProductosController {
	
	@Autowired
	private ProductosService service;
	
	@GetMapping("/list")
	public List<Producto> list() {
		return service.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Producto detail(@PathVariable Long id) {
		return service.findById(id);
	}
	
	
	// @DeleteMapping
	// @PostMapping
	// @Put
}
