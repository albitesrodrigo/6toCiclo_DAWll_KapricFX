package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.RolCreateDTO;
import com.proyectosistemaventas.dtos.RolDTO;
import com.proyectosistemaventas.dtos.RolUpdateDTO;

import java.util.List;

public interface RolService {

    List<RolDTO> listarRoles();
    RolDTO obtenerRolPorId(long id);
    RolDTO registrarRol(RolCreateDTO rolCreateDTO);
    RolDTO actualizarRol(RolUpdateDTO rolUpdateDTO);
    RolDTO eliminarRol(long id);
}
