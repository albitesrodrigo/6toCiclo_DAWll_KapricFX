package com.proyectosistemaventas.mapper;

import com.proyectosistemaventas.dtos.EmpleadoCreateDTO;
import com.proyectosistemaventas.dtos.EmpleadoDTO;
import com.proyectosistemaventas.dtos.EmpleadoUpdateDTO;
import com.proyectosistemaventas.model.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmpleadoMapper {

    EmpleadoMapper instacia =  Mappers.getMapper(EmpleadoMapper.class);

    EmpleadoDTO empleadoAEmpleadoDTO(Empleado empleado);
    Empleado empleadoDTOAEmpleado(EmpleadoDTO empleadoDto);
    Empleado empleadoCreateDTOAEmpleado(EmpleadoCreateDTO empleadoCreateDTO);
    Empleado empleadoUpdateDTOAEmpleado(EmpleadoUpdateDTO empleadoUpdateDTO);
    List<EmpleadoDTO>listaEmpleadoAListaEmpleadoDTO(List<Empleado>listaEmpleado);

}
