package com.salespoint.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salespoint.model.Sucursal;

public interface ISucursalDAO extends JpaRepository<Sucursal, Integer>{

}
