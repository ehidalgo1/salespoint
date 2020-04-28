package com.salespoint.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salespoint.model.Inventario;

public interface IinventarioDAO extends JpaRepository<Inventario, Long>{

}
