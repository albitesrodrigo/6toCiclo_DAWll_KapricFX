package com.proyectosistemaventas.mapper;

import com.proyectosistemaventas.dtos.ProductoCreateDTO;
import com.proyectosistemaventas.dtos.ProductoDTO;
import com.proyectosistemaventas.dtos.ProductoUpdateDTO;
import com.proyectosistemaventas.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {

    ProductoMapper instancia = Mappers.getMapper(ProductoMapper.class);

    ProductoDTO productoAProductoDTO(Producto producto);
    Producto productoDTOAProducto(ProductoDTO productoDTO);
    Producto productoCreateDTOAProducto(ProductoCreateDTO productoCreateDTO);
    Producto productoUpdateDTOAProducto(ProductoUpdateDTO productoUpdateDTO);
    List<ProductoDTO>listaProductoAListaProductoDTO(List<Producto>listProducto);

}
