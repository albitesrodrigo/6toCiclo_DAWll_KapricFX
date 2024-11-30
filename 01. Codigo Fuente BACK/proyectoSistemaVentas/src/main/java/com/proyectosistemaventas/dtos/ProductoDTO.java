package com.proyectosistemaventas.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductoDTO {

    private Long idProducto;
    private String nomProducto;
    private Integer stock;
    private BigDecimal precio;

    private CategoriaDTO categoria;

}
