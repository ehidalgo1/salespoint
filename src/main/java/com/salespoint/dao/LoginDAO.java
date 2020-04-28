package com.salespoint.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.salespoint.interfaces.ILoginDAO;

@Repository
public class LoginDAO {

	@Autowired
	private ILoginDAO iLoginDAO;
	
	public ILoginDAO BD() {
		return this.iLoginDAO;
	}
	
}
