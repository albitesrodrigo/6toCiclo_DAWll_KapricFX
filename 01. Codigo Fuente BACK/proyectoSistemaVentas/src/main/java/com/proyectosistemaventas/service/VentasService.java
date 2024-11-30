package com.proyectosistemaventas.service;


import com.proyectosistemaventas.dtos.VentasCreateDTO;
import com.proyectosistemaventas.dtos.VentasDTO;

import java.util.List;

public interface VentasService {

    List<VentasDTO> listarVentas();
    VentasDTO obtenerVentasPorID(long id);
    VentasDTO registrarVentas(VentasCreateDTO ventasCreateDTO);

}
