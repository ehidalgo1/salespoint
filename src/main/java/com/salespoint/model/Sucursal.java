package com.salespoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
public class Sucursal {

	@Id
	@Column(name = "ID_SUCURSAL")
	private int idSucursal;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_COMUNA")
	private Comuna comuna;
	
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}

	public Sucursal(int idSucursal, String nombre, String direccion, Comuna comuna) {
		super();
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.direccion = direccion;
		this.comuna = comuna;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}
	
	
}
