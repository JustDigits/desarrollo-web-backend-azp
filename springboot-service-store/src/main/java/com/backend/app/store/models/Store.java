package com.backend.app.store.models;

public class Store {
	private Producto prod;
	private Integer cantidad;
	
	
	public Store() {
		
	}
	
	public Store(Producto prod, Integer cantidad) {
		this.prod = prod;
		this.cantidad = cantidad;
	}
	public Producto getProd() {
		return prod;
	}
	public void setProd(Producto prod) {
		this.prod = prod;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
//	public Double getTotal() {
//		return product.getPrice() * cantidad.doubleValue();
//	}
}
