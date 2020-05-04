package com.salespoint.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salespoint.model.Factura;

public interface IFacturaDAO extends JpaRepository<Factura, Long>{

}
