package com.salespoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Comuna.findAll", query = "Select c FROM Comuna c")
public class Comuna {

	@Id
	@Column(name = "ID_COMUNA")
	private Long idComuna;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_CIUDAD")
	private Ciudad ciudad;
	
	
	public Comuna() {
		// TODO Auto-generated constructor stub
	}


	public Comuna(Long idComuna, String nombre, Ciudad ciudad) {
		super();
		this.idComuna = idComuna;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}


	public Long getIdComuna() {
		return idComuna;
	}


	public void setIdComuna(Long idComuna) {
		this.idComuna = idComuna;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Ciudad getCiudad() {
		return ciudad;
	}


	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
}
