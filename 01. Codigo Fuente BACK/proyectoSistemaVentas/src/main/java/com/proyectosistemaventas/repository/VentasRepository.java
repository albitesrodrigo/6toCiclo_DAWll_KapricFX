package com.proyectosistemaventas.repository;

import com.proyectosistemaventas.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {
}
