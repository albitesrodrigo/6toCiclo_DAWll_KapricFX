package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.EmpleadoCreateDTO;
import com.proyectosistemaventas.dtos.EmpleadoDTO;
import com.proyectosistemaventas.dtos.EmpleadoUpdateDTO;

import java.util.List;

public interface EmpleadoService {

    List<EmpleadoDTO> listarEmpleado();
    EmpleadoDTO obtenerEmpleadoPorID(long id);
    EmpleadoDTO registrarEmpleado(EmpleadoCreateDTO empleadoCreateDTO);
    EmpleadoDTO actualizarEmpleado(EmpleadoUpdateDTO empleadoUpdateDTO);
    EmpleadoDTO eliminarEmpleado(long id);

}
