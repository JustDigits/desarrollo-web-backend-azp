package com.backend.app.productos.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.app.productos.models.dao.ProductosDao;
import com.backend.app.productos.models.entity.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {
	
	@Autowired
	private ProductosDao productosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Long id) {
		return productosDao.findById(id);
	}
	
	@Override
	public void deleteAll() {
		productosDao.deleteAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public void deleteById(Long id) {
		productosDao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Producto save(Producto instance) {
	    return productosDao.save(instance);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean existsById(Long id) {
		return productosDao.existsById(id);
	}
}

// @DeleteMapping
// @PostMapping
// @Put
