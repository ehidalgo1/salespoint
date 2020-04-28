package com.salespoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "FAMILIA_PRODUCTO")
@NamedQuery(name = "FamiliaProducto.findAll", query = "SELECT fp FROM FamiliaProducto fp")
public class FamiliaProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_FAMILIA")
	private Long idFamilia;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	public FamiliaProducto() {
		// TODO Auto-generated constructor stub
	}
	
	public FamiliaProducto(Long idFamilia, String nombre) {
		super();
		this.idFamilia = idFamilia;
		this.nombre = nombre;
	}

	public Long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
