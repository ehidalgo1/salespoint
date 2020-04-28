package com.salespoint.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salespoint.dao.ProductoDAO;
import com.salespoint.model.Producto;

@RestController
@RequestMapping("/api")
public class ProductoRest {

	@Autowired
	private ProductoDAO productDAO;
	
	@GetMapping("/producto")
	public List<Producto> getListaProductos(){
		List<Producto> listaProductos = null;
		
		try {
			
			listaProductos = productDAO.BD().findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			listaProductos = new ArrayList<Producto>();
		}
		
		return listaProductos;
	}
	
}
