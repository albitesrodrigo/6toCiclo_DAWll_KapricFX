package com.proyectosistemaventas.mapper;

import com.proyectosistemaventas.dtos.VentasCreateDTO;
import com.proyectosistemaventas.dtos.VentasDTO;
import com.proyectosistemaventas.model.Ventas;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VentasMapper {

    VentasMapper instancia = Mappers.getMapper(VentasMapper.class);

    VentasDTO ventasAVentasDTO(Ventas ventas);
    Ventas ventasDTOAVentas(VentasDTO ventasDTO);
    Ventas ventasCreateDTOAVentas(VentasCreateDTO ventasCreateDTO);
    List<VentasDTO>listaVentasAVentasDTO(List<Ventas>listaVentas);



}
