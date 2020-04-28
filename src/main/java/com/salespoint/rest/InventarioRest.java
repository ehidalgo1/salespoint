package com.salespoint.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salespoint.dao.InventarioDAO;
import com.salespoint.model.Inventario;
@RestController
@RequestMapping("/api")
public class InventarioRest {

	@Autowired
	private InventarioDAO inventDAO;
	
	@GetMapping("/inventario")
	public List<Inventario> getListaInventario(){
		List<Inventario> listaInventario = null;
		
		try {
			
			
			listaInventario = inventDAO.BD().findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			listaInventario = new ArrayList<Inventario>();
		}
		
		return listaInventario;
	}
	
	
	
}
