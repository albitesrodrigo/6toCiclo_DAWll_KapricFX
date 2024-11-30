package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.EstadoCreateDTO;
import com.proyectosistemaventas.dtos.EstadoDTO;
import com.proyectosistemaventas.dtos.EstadoUpdateDTO;

import java.util.List;

public interface EstadoService {

    List<EstadoDTO> listarEstados();
    EstadoDTO obtenerEstadoPorID(long id);
    EstadoDTO registrarEstado(EstadoCreateDTO estadoCreateDTO);
    EstadoDTO actualizarEstado(EstadoUpdateDTO estadoUpdateDTO);
    EstadoDTO eliminarEstado(long id);
}
