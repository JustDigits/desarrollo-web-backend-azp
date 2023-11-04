package com.backend.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.app.productos.models.entity.Producto;

public interface ProductosDao extends CrudRepository<Producto,Long> {

}
