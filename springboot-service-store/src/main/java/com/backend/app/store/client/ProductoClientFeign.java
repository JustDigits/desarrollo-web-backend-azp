package com.backend.app.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.app.store.models.Producto;

@FeignClient(name = "service-productos")
public interface ProductoClientFeign {

	@GetMapping("/list")
	public List<Producto> findAll();
	
	@GetMapping("/productos/{id}")
	public Producto findById(@PathVariable Long id);
}
