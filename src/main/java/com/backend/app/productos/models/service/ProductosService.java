package com.backend.app.productos.models.service;

import java.util.List;

import com.backend.app.productos.models.entity.Producto;

public interface ProductosService {
	
	/**
	 * Retorna el listado de todos los productos.
	 * @return
	 */
	public List<Producto> findAll();
	
	/**
	 * Retorna un producto específico según su ID.
	 * @param id - ID del producto.
	 * @return
	 */
	public Producto findById(Long id);
	
	// @DeleteMapping
	// @PostMapping
	// @Put
}
