package com.salespoint.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salespoint.dao.FacturaDAO;
import com.salespoint.model.Factura;

@RestController
@RequestMapping("/api")
public class FacturaRest {

	@Autowired
	private FacturaDAO factDAO;
	
	@GetMapping("/factura")
	public List<Factura> getListaFacturas(){
		List<Factura> listaFacturas = null;
		
		try {
			
			listaFacturas = factDAO.BD().findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			listaFacturas = new ArrayList<Factura>();
		}
		
		return listaFacturas;
	}
	
}
