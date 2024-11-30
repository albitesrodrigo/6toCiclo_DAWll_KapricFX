package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.*;
import com.proyectosistemaventas.mapper.EmpleadoMapper;
import com.proyectosistemaventas.model.Empleado;
import com.proyectosistemaventas.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public List<EmpleadoDTO> listarEmpleado() {

        return EmpleadoMapper.instacia.listaEmpleadoAListaEmpleadoDTO(empleadoRepository.findAll());
    }


    @Override
    public EmpleadoDTO obtenerEmpleadoPorID(long id) {
        Optional<Empleado> empleado=empleadoRepository.findById(id);
        EmpleadoDTO empleadoDto=null;
        if (empleado.isPresent()){
            empleadoDto=EmpleadoMapper.instacia.empleadoAEmpleadoDTO(empleado.get());
        }
        return empleadoDto;
    }


    @Override
    public EmpleadoDTO registrarEmpleado(EmpleadoCreateDTO empleadoCreateDTO) {
        Empleado empleado=EmpleadoMapper.instacia.empleadoCreateDTOAEmpleado(empleadoCreateDTO);
        Empleado respuestaEntety=empleadoRepository.save(empleado);
        EmpleadoDTO respuestaDTO= EmpleadoMapper.instacia.empleadoAEmpleadoDTO(respuestaEntety);
        return respuestaDTO;
    }

    @Override
    public EmpleadoDTO actualizarEmpleado(EmpleadoUpdateDTO empleadoUpdateDTO) {
        Empleado empleado=EmpleadoMapper.instacia.empleadoUpdateDTOAEmpleado(empleadoUpdateDTO);
        Empleado respuestaEntety=empleadoRepository.save(empleado);
        EmpleadoDTO respuestaDTO=EmpleadoMapper.instacia.empleadoAEmpleadoDTO(respuestaEntety);
        return respuestaDTO;
    }

    @Override
    public EmpleadoDTO eliminarEmpleado(long id) {
        Optional<Empleado>empleadoOptional=empleadoRepository.findById(id);
        if (!empleadoOptional.isPresent()){
            throw new NoSuchElementException("Emplado no encontrado");
        }
        Empleado empleadoExistente=empleadoOptional.get();
        empleadoRepository.delete(empleadoExistente);
        return EmpleadoMapper.instacia.empleadoAEmpleadoDTO(empleadoExistente);
    }
}
