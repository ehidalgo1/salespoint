package com.salespoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
public class Inventario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "ID_INVENTARIO")
	private Long idInventario;
	
	@Column(name = "STOCK_VENTAS")
	private int stockVentas;
	
	@Column(name="STOCK_ACTUAL")
	private int stockActual;
	
	@Column(name="STOCK_PROMEDIO")
	private int stockPromedio;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_PRODUCTO")
	private Producto producto;
	
	public Inventario() {
		// TODO Auto-generated constructor stub
	}

	public Inventario(Long idInventario, int stockVentas, int stockActual, int stockPromedio, Producto producto) {
		super();
		this.idInventario = idInventario;
		this.stockVentas = stockVentas;
		this.stockActual = stockActual;
		this.stockPromedio = stockPromedio;
		this.producto = producto;
	}

	public Long getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(Long idInventario) {
		this.idInventario = idInventario;
	}

	public int getStockVentas() {
		return stockVentas;
	}

	public void setStockVentas(int stockVentas) {
		this.stockVentas = stockVentas;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockPromedio() {
		return stockPromedio;
	}

	public void setStockPromedio(int stockPromedio) {
		this.stockPromedio = stockPromedio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
