package com.salespoint.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salespoint.dao.FamiliaProductoDAO;
import com.salespoint.dao.ProductoDAO;
import com.salespoint.model.FamiliaProducto;
import com.salespoint.model.Producto;

@RestController
@RequestMapping("/api")
public class ProductoRest {

	@Autowired
	private ProductoDAO productDAO;
	
	@Autowired
	private FamiliaProductoDAO famiDAO;
	
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
	
	@GetMapping("/producto/get/{idProducto}")
	public Optional<Producto> getProducto(@PathVariable Long idProducto){
		Optional<Producto> producto = null;
		
		try {
			
			producto = productDAO.BD().findById(idProducto);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return producto;
	}
	
	@PostMapping("/producto/add")
	public int addProducto(@RequestBody Producto prod){
		
		Producto producto = null;
		int respuestaSevidor = 0;
		
		
		try {
			
			FamiliaProducto famProd = famiDAO.BD().getOne(prod.getFamiliaProducto().getIdFamilia());
			
			if (famProd!=null) {
				
				Long idProducto = productDAO.BD().count() + 1;
				
				producto = new Producto(idProducto, prod.getNombre().toUpperCase(), famProd);
				
				productDAO.BD().save(producto);
				
				respuestaSevidor = 200;
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respuestaSevidor = 500;

		}
		
		return respuestaSevidor;
		
	}
	
	
	@PutMapping("/producto/edit/{idProducto}")
	public int editarProducto(@PathVariable Long idProducto, @RequestBody Producto prod) {
		
		Producto producto = null;
		FamiliaProducto familia = null;
		int respuestaServidor = 0;
		
		try {
			
			producto = productDAO.BD().getOne(idProducto);
			
			familia = famiDAO.BD().getOne(prod.getFamiliaProducto().getIdFamilia());
			
			
			if (producto!=null && familia!=null) {
				
				producto.setNombre(prod.getNombre());
				producto.setFamiliaProducto(familia);
				
				productDAO.BD().save(producto);
				
				respuestaServidor = 200;
				
			}else {
				
				//not found
				respuestaServidor = 100;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respuestaServidor = 500;
		}
		
		return respuestaServidor;
	}
	
	@DeleteMapping("/producto/delete/{idProducto}")
	public int deleteProducto(@PathVariable Long idProducto) {
		
		Producto producto = null;
		int respuestaServidor = 0;
		try {
			
			producto = productDAO.BD().getOne(idProducto);
			
			if (producto!=null) {
				productDAO.BD().delete(producto);
				
				respuestaServidor = 200;
			}else {
				//not found
				respuestaServidor = 100;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respuestaServidor = 500;
		}
		
		return respuestaServidor;
	}
	
}
