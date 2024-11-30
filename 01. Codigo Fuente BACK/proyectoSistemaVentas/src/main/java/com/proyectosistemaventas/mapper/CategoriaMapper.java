package com.proyectosistemaventas.mapper;

import com.proyectosistemaventas.dtos.CategoriaCreateDTO;
import com.proyectosistemaventas.dtos.CategoriaDTO;
import com.proyectosistemaventas.dtos.CategoriaUpdateDTO;
import com.proyectosistemaventas.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper instancia= Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO categoriaACategoriaDTO(Categoria categoria);
    Categoria categoriaDTOACategoria(CategoriaDTO categoriaDTO);
    Categoria  categoriaCreateDTOACategoria(CategoriaCreateDTO categoriaCreateDTO);
    Categoria categoriaUpdateDTOACategoria(CategoriaUpdateDTO categoriaUpdateDTO);
    List<CategoriaDTO> listaCategoriaAListaCategoriaDTO (List<Categoria> listaCategoria);

}
