package com.backend.app.store.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.store.models.Producto;
import com.backend.app.store.models.Store;
import com.backend.app.store.models.services.StoreService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class StoreController {
	
	@Autowired
	//@Qualifier("serviceFeign")
	private StoreService storeService;
	
	@GetMapping("/list")
	public List<Store> list() {
		return storeService.findAll();
	}
	
	@HystrixCommand(fallbackMethod="metodoGenerico")
	@GetMapping("/store/{id}/cantidad/{cantidad}")
	public Store details(@PathVariable Long id, @PathVariable Integer cantidad) {
		return storeService.findById(id, cantidad);
	} 
	
	public Store metodoGenerico(Long id, Integer cantidad) {
		Store store = new Store();
		Producto prod = new Producto(id, "El Cel del Profe", "Samsung", 0);
		
		store.setCantidad(cantidad);
		store.setProd(prod);
		
		return store;
	} 
}
