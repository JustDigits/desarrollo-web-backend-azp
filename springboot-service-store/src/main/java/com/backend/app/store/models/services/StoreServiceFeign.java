package com.backend.app.store.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.backend.app.store.client.ProductoClientFeign;
import com.backend.app.store.models.Store;

@Service("serviceFeign")
@Primary
public class StoreServiceFeign implements StoreService {

	@Autowired
	private ProductoClientFeign clientFeign;
	
	@Override
	public List<Store> findAll() {
		return clientFeign.findAll().stream().map(p -> new Store(p, 5)).collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer cantidad) {
		return new Store(clientFeign.findById(id), cantidad);
	}

}
