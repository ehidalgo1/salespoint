package com.salespoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PRODUCTO")
	private Long idProducto;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_FAMILIA")
	private FamiliaProducto familiaProducto;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(Long idProducto, String nombre, FamiliaProducto familiaProducto) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.familiaProducto = familiaProducto;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public FamiliaProducto getFamiliaProducto() {
		return familiaProducto;
	}

	public void setFamiliaProducto(FamiliaProducto familiaProducto) {
		this.familiaProducto = familiaProducto;
	}
	
	
	
}
