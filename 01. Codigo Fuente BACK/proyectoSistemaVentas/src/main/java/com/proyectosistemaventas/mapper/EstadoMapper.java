package com.proyectosistemaventas.mapper;

import com.proyectosistemaventas.dtos.EstadoCreateDTO;
import com.proyectosistemaventas.dtos.EstadoDTO;
import com.proyectosistemaventas.dtos.EstadoUpdateDTO;
import com.proyectosistemaventas.model.Estado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EstadoMapper {

    EstadoMapper instancia = Mappers.getMapper(EstadoMapper.class);

    EstadoDTO estadoAEstadoDTO(Estado estado);
    Estado estadoDTOAEstado(EstadoDTO estadoDTO);
    Estado  estadoCreateDTOAEstado(EstadoCreateDTO colorCreateDTO);
    Estado estadoUpdateDTOAEstado(EstadoUpdateDTO colorUpdateDTO);
    List<EstadoDTO> listaEstadoAListaEstadoDTO (List<Estado> listaEstado);

}
