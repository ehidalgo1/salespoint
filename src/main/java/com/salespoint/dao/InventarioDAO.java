package com.salespoint.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salespoint.interfaces.IinventarioDAO;

@Repository
public class InventarioDAO {

	@Autowired
	private IinventarioDAO iInventaDAO;
	
	public IinventarioDAO BD() {
		return this.iInventaDAO;
	}
	
}
