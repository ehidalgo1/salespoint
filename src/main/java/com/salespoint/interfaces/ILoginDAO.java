package com.salespoint.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salespoint.model.Login;

public interface ILoginDAO extends JpaRepository<Login, Long>{

}
