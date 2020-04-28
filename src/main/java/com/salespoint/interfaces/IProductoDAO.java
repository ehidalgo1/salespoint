package com.salespoint.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salespoint.model.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Long>{

}
