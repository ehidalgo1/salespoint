package com.salespoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.springframework.data.querydsl.binding.QuerydslPredicate;
@Entity
@NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
public class Login implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_LOGIN")
	private Long idLogin;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;

	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Login(Long idLogin, String username, String password) {
		super();
		this.idLogin = idLogin;
		this.username = username;
		this.password = password;
	}


	public Long getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Long idLogin) {
		this.idLogin = idLogin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
