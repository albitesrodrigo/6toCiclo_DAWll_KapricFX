package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.ProductoCreateDTO;
import com.proyectosistemaventas.dtos.ProductoDTO;
import com.proyectosistemaventas.dtos.ProductoUpdateDTO;
import com.proyectosistemaventas.mapper.ProductoMapper;
import com.proyectosistemaventas.model.Producto;
import com.proyectosistemaventas.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements  PorductoService{

  @Autowired
  private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProducto() {
        return ProductoMapper.instancia.listaProductoAListaProductoDTO(productoRepository.findAll());
    }

    @Override
    public ProductoDTO obtenerProductoPorId(long id) {
        Optional<Producto> producto=productoRepository.findById(id);
        ProductoDTO productoDTO=null;
        if (producto.isPresent()){
            productoDTO=ProductoMapper.instancia.productoAProductoDTO(producto.get());
        }
        return productoDTO;
    }

    @Override
    public ProductoDTO resgistrarProducto(ProductoCreateDTO productoCreateDTO) {

        Producto producto=ProductoMapper.instancia.productoCreateDTOAProducto(productoCreateDTO);
        Producto respuestaEntety=productoRepository.save(producto);
        ProductoDTO respuesatDTO = ProductoMapper.instancia.productoAProductoDTO(respuestaEntety);

        return respuesatDTO;
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO) {
        Producto producto=ProductoMapper.instancia.productoUpdateDTOAProducto(productoUpdateDTO);
        Producto respuestaEntety=productoRepository.save(producto);
        ProductoDTO respuestaDTO=ProductoMapper.instancia.productoAProductoDTO(respuestaEntety);
        return respuestaDTO;
    }

    @Override
    public ProductoDTO eliminarProducto(long id) {
        Optional<Producto>productoOptional=productoRepository.findById(id);
        if (productoOptional.isPresent()){
            ProductoDTO productoDTO=ProductoMapper.instancia.productoAProductoDTO(productoOptional.get());
            productoRepository.delete((productoOptional.get()));
            return productoDTO;
        }
        else {
            throw  new NoSuchElementException("No se pudo realizar la eliminacion para el ID proporcionado");
        }
    }
}
