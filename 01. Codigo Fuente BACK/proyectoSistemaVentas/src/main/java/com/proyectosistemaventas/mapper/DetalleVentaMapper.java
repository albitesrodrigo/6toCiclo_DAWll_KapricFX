package com.proyectosistemaventas.mapper;

import com.proyectosistemaventas.dtos.DetalleVentaCreateDTO;
import com.proyectosistemaventas.dtos.DetalleVentaDTO;
import com.proyectosistemaventas.model.DetalleVenta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DetalleVentaMapper {

    DetalleVentaMapper instancia = Mappers.getMapper(DetalleVentaMapper.class);

    DetalleVentaDTO detalleVentaDTOADetalleVenta(DetalleVenta detalleVenta);
    DetalleVenta detalleVentaCreateDTOADetalleVenta(DetalleVentaCreateDTO detalleVentaCreateDTO);
    List<DetalleVentaDTO>listaDetalleVentaADetalleVentaDTO(List<DetalleVenta>listaDetalleVenta);





}
