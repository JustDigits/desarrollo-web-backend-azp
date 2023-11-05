package com.backend.app.productos.models.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
	private Environment env;
	
	@Autowired
	private ProductosService service;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/list")
	public List<Producto> findAll() {
		return service.findAll().stream().map(producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/productos/{id}")
	public Producto findById(@PathVariable Long id) {
	
		try {
			Thread.sleep(2000L);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		Optional<Producto> optionalProducto = service.findById(id);
	    if (!optionalProducto.isPresent()) {
	    	return new Producto();
	    }
	    return optionalProducto.get();
	}
	
	@DeleteMapping("/productos")
	public ResponseEntity<?> deleteAll() {
		service.deleteAll();
		return new ResponseEntity<>("Todos los productos eliminados.", HttpStatus.OK);
	}
	
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<Void> drop(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/producto")
	public ResponseEntity<Producto> add(@RequestBody Producto instance) {
		// Set current date and time
		instance.setAddedAt(new Date());
		
		Producto saveProd = service.save(instance);
		return new ResponseEntity<>(saveProd, HttpStatus.CREATED);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto instance) {
		if(service.existsById(id)) {
			instance.setId(id);
			Producto updateProd = service.save(instance);
			return new ResponseEntity<>(updateProd, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}