package com.salespoint.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salespoint.interfaces.IFacturaDAO;

@Repository
public class FacturaDAO {

	@Autowired
	private IFacturaDAO iFacturaDAO;
	
	public IFacturaDAO BD() {
		return this.iFacturaDAO;
	}
	
}
