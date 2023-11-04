package com.backend.app.productos.models.service;

import java.util.List;
import java.util.Optional;

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
	public Optional<Producto> findById(Long id);
	
	/**
	 * Elimina todos los productos.
	 */
	public void deleteAll();
	
	/**
	 * Elimina un producto específico según su ID. 
	 * @param id - ID del producto.
	 * @return
	 */
	public void deleteById(Long id);
	
	/**
	 * Guarda un producto en la base de datos.
	 * @param producto
	 * @return
	 */
	public Producto save(Producto instance);
	
	public boolean existsById(Long id);
}