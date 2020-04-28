package com.salespoint.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salespoint.dao.LoginDAO;
import com.salespoint.model.Login;

@RestController
@RequestMapping("/api")
public class LoginRest {

	@Autowired
	private LoginDAO loginDAO;
	
	@GetMapping("/login")
	public List<Login> listaLogin(){
		List<Login> listaLogin = null;
		
		try {
			
			listaLogin = loginDAO.BD().findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			listaLogin = new ArrayList<Login>();
		}
		
		return listaLogin;
	}
	
}
