package com.salespoint.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salespoint.interfaces.ISucursalDAO;

@Repository
public class SucursalDAO {

	@Autowired
	private ISucursalDAO iSucursalDAO;
	
	public ISucursalDAO BD() {
		return this.iSucursalDAO;
	}
	
}
