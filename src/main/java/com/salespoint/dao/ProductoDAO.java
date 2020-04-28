package com.salespoint.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salespoint.interfaces.IProductoDAO;

@Repository
public class ProductoDAO {

	@Autowired
	private IProductoDAO iProductoDAO;
	
	public IProductoDAO BD() {
		return this.iProductoDAO;
	}
	
}
