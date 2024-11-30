package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.CategoriaCreateDTO;
import com.proyectosistemaventas.dtos.CategoriaDTO;
import com.proyectosistemaventas.dtos.CategoriaUpdateDTO;

import java.util.List;

public interface CategoriaService {

    List<CategoriaDTO> listarCategorias();
    CategoriaDTO obtenerCategoriaPorID(long id);
    CategoriaDTO registrarCategoria(CategoriaCreateDTO categoriaCreateDTO);
    CategoriaDTO actualizarCategoria(CategoriaUpdateDTO categoriaUpdateDTO);
    CategoriaDTO eliminarCategoria(long id);
}
