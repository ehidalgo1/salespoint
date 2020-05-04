package com.salespoint.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salespoint.dao.SucursalDAO;
import com.salespoint.model.Sucursal;

@RestController
@RequestMapping("/api")
public class SucursalRest {

	@Autowired
	private SucursalDAO sucurDAO;
	
	@GetMapping("/sucursal")
	public List<Sucursal> getListaSucursales(){
		List<Sucursal> listaSucursales = null;
		
		try {
			
			listaSucursales = sucurDAO.BD().findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			listaSucursales = new ArrayList<Sucursal>();
		}
		
		return listaSucursales;
	}
}
