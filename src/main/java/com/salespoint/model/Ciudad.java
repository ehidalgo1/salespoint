package com.salespoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
public class Ciudad {

	
	@Id
	@Column(name = "ID_CIUDAD")
	private int idCiudad;
	
	@Column(name = "nombre")
	private String nombre;
	
	public Ciudad() {
		// TODO Auto-generated constructor stub
	}

	public Ciudad(int idCiudad, String nombre) {
		super();
		this.idCiudad = idCiudad;
		this.nombre = nombre;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
