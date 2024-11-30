package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.ProductoCreateDTO;
import com.proyectosistemaventas.dtos.ProductoDTO;
import com.proyectosistemaventas.dtos.ProductoUpdateDTO;

import java.util.List;

public interface PorductoService {

    List<ProductoDTO>listarProducto();
    ProductoDTO obtenerProductoPorId(long id);
    ProductoDTO resgistrarProducto(ProductoCreateDTO productoCreateDTO);
    ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO);
    ProductoDTO eliminarProducto(long id);

}
