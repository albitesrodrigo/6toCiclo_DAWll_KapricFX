package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.UsuarioCreateDTO;
import com.proyectosistemaventas.dtos.UsuarioDTO;
import com.proyectosistemaventas.dtos.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO obtenerUsuarioPorID(long id);
    UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO);
    UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO);
    UsuarioDTO eliminarUsuario(long id);
}
