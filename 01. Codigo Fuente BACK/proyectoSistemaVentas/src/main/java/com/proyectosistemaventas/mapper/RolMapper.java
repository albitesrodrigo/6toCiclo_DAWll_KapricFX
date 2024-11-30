package com.proyectosistemaventas.mapper;

import com.proyectosistemaventas.dtos.RolCreateDTO;
import com.proyectosistemaventas.dtos.RolDTO;
import com.proyectosistemaventas.dtos.RolUpdateDTO;
import com.proyectosistemaventas.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RolMapper {

    RolMapper instancia = Mappers.getMapper(RolMapper.class);
    RolDTO rolARolDTO(Rol rol);
    Rol rolDTOARol(RolDTO rolesDTO);
    Rol rolCreateDTOARol(RolCreateDTO rolCreateDTO);
    Rol rolUpdateDTOARol(RolUpdateDTO rolUpdateDTO);

    List<RolDTO> listaRolAListaRolDTO(List<Rol> listaRol);

}
