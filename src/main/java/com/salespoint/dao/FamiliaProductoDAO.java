package com.salespoint.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salespoint.interfaces.IFamiliaProductoDAO;

@Repository
public class FamiliaProductoDAO {

	@Autowired
	private IFamiliaProductoDAO iFamiliaProductoDAO;
	
	public IFamiliaProductoDAO BD() {
		return this.iFamiliaProductoDAO;
	}
	
}
