package com.backend.app.store.models.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.app.store.models.Producto;
import com.backend.app.store.models.Store;

@Service("serviceRest")
public class StoreServiceImpl implements StoreService {

	@Autowired
	private RestTemplate clientRest; 
	
	@Override
	public List<Store> findAll() {
		List<Producto> productos = Arrays.asList(clientRest.getForObject("http://localhost:8081/list" , Producto[].class));
		
		return productos.stream().map(p -> new Store(p, 5)).collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Producto prod = clientRest.getForObject("http://localhost:8081/productos/{id}", Producto.class, pathVariables);
		return new Store(prod, cantidad);
	}

}
