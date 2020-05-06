package com.salespoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salespoint.dao.FamiliaProductoDAO;
import com.salespoint.dao.ProductoDAO;
import com.salespoint.model.FamiliaProducto;

@Controller
public class WebController {
	
	@Autowired
	private FamiliaProductoDAO famProDAO;

	@RequestMapping({"/",""})
	public String goHome() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String goLogin() {
		return "login";
	}
	
	@RequestMapping("/productos")
	public String goProductos(Model model) {

		List<FamiliaProducto> listaFamilia = null;
		
		try {
			
			listaFamilia = famProDAO.BD().findAll();
			model.addAttribute("listaFamilia", listaFamilia);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "productos";
	}
	
	@RequestMapping("/inventario")
	public String goInventario() {
		return "inventario";
	}
	
	@RequestMapping("/facturas")
	public String goFacturas() {
		return "facturas";
	}
}
