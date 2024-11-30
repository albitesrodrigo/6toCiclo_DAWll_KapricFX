package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.EstadoCreateDTO;
import com.proyectosistemaventas.dtos.EstadoDTO;
import com.proyectosistemaventas.dtos.EstadoUpdateDTO;
import com.proyectosistemaventas.mapper.EstadoMapper;
import com.proyectosistemaventas.model.Estado;
import com.proyectosistemaventas.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<EstadoDTO> listarEstados() {
        return EstadoMapper.instancia.listaEstadoAListaEstadoDTO( estadoRepository.findAll());
    }

    @Override
    public EstadoDTO obtenerEstadoPorID(long id) {
        Optional<Estado> estado= estadoRepository.findById(id);
        EstadoDTO estadoDTO =null;
        if(estado.isPresent()){
            estadoDTO = EstadoMapper.instancia.estadoAEstadoDTO(estado.get());
        }
        return  estadoDTO;
    }

    @Override
    public EstadoDTO registrarEstado(EstadoCreateDTO estadoCreateDTO) {
        Estado estado=EstadoMapper.instancia.estadoCreateDTOAEstado(estadoCreateDTO);
        Estado respuestaEntity=estadoRepository.save(estado);
        EstadoDTO respuestaDTO= EstadoMapper.instancia.estadoAEstadoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public EstadoDTO actualizarEstado(EstadoUpdateDTO estadoUpdateDTO) {
        Estado estado=EstadoMapper.instancia.estadoUpdateDTOAEstado(estadoUpdateDTO);
        Estado respuestaEntity=estadoRepository.save(estado);
        EstadoDTO respuestaDTO= EstadoMapper.instancia.estadoAEstadoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public EstadoDTO eliminarEstado(long id) {
        Optional<Estado> estadoOptional = estadoRepository.findById(id);
        if (estadoOptional.isPresent()) {
            EstadoDTO estadoDTO = EstadoMapper.instancia.estadoAEstadoDTO(estadoOptional.get());
            estadoRepository.delete(estadoOptional.get());
            return estadoDTO;
        } else {
            throw new NoSuchElementException("No se pudo realizar la eliminación para el ID proporcionado");
        }
    }
}
