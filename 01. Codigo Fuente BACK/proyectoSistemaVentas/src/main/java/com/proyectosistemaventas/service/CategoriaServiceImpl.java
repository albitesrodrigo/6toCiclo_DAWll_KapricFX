package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.CategoriaCreateDTO;
import com.proyectosistemaventas.dtos.CategoriaDTO;
import com.proyectosistemaventas.dtos.CategoriaUpdateDTO;
import com.proyectosistemaventas.mapper.CategoriaMapper;
import com.proyectosistemaventas.model.Categoria;
import com.proyectosistemaventas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return CategoriaMapper.instancia.listaCategoriaAListaCategoriaDTO(categoriaRepository.findAll());
    }

    @Override
    public CategoriaDTO obtenerCategoriaPorID(long id) {
        Optional<Categoria> categoria= categoriaRepository.findById(id);
        CategoriaDTO categoriaDTO =null;
        if(categoria.isPresent()){
            categoriaDTO = CategoriaMapper.instancia.categoriaACategoriaDTO(categoria.get());
        }
        return  categoriaDTO;
    }

    @Override
    public CategoriaDTO registrarCategoria(CategoriaCreateDTO categoriaCreateDTO) {
        Categoria categoria=CategoriaMapper.instancia.categoriaCreateDTOACategoria(categoriaCreateDTO);
        Categoria respuestaEntity=categoriaRepository.save(categoria);
        CategoriaDTO respuestaDTO= CategoriaMapper.instancia.categoriaACategoriaDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public CategoriaDTO actualizarCategoria(CategoriaUpdateDTO categoriaUpdateDTO) {
        Categoria categoria=CategoriaMapper.instancia.categoriaUpdateDTOACategoria(categoriaUpdateDTO);
        Categoria respuestaEntity=categoriaRepository.save(categoria);
        CategoriaDTO respuestaDTO= CategoriaMapper.instancia.categoriaACategoriaDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public CategoriaDTO eliminarCategoria(long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            CategoriaDTO categoriaDTO = CategoriaMapper.instancia.categoriaACategoriaDTO(categoriaOptional.get());
            categoriaRepository.delete(categoriaOptional.get());
            return categoriaDTO;
        } else {
            throw new NoSuchElementException("No se pudo realizar la eliminación para el ID proporcionado");
        }
    }
}
