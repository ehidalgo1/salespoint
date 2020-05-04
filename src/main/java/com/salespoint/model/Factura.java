package com.salespoint.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
public class Factura {
	
	@Id
	@Column(name = "ID_FACTURA")
	private Long idFactura;
	
	@Column(name = "COD_FACTURA")
	private int codFactura;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_SUCURSAL")
	private Sucursal sucursal;
	
	@ManyToMany
	@JoinTable(name = "FACTURA_PRODUCTO",
	joinColumns = {
			@JoinColumn(name="FK_ID_FACTURA")
			},
	inverseJoinColumns = {
			@JoinColumn(name="FK_ID_PRODUCTO")
	})
	private List<Producto> productos;
	
	public Factura() {
		// TODO Auto-generated constructor stub
	}

	public Factura(Long idFactura, int codFactura, Date fecha, Sucursal sucursal, List<Producto> productos) {
		super();
		this.idFactura = idFactura;
		this.codFactura = codFactura;
		this.fecha = fecha;
		this.sucursal = sucursal;
		this.productos = productos;
	}

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public int getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(int codFactura) {
		this.codFactura = codFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	

}
