package com.proyectosistemaventas.mapper;

import com.proyectosistemaventas.dtos.UsuarioCreateDTO;
import com.proyectosistemaventas.dtos.UsuarioDTO;
import com.proyectosistemaventas.dtos.UsuarioUpdateDTO;
import com.proyectosistemaventas.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper instancia = Mappers.getMapper(UsuarioMapper.class);
    UsuarioDTO usuarioAUsuarioDTO(Usuario usuario);
    Usuario usuarioDTOAUsuario(UsuarioDTO usuarioDTO);
    Usuario usuarioCreateDTOAUsuario(UsuarioCreateDTO usuarioCreateDTO);
    Usuario usuarioUpdateDTOAUsuario(UsuarioUpdateDTO usuarioUpdateDTO);
    List<UsuarioDTO> listaUsuarioAListaUsuarioDTO(List<Usuario> listaUsuario);

}
