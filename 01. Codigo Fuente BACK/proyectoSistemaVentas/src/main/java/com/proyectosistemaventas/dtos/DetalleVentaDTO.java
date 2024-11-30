package com.proyectosistemaventas.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DetalleVentaDTO {

    private Long idDetalleVenta;
    private ProductoDTO producto;
    private Integer cantidad;
    private BigDecimal preVenta;
    private BigDecimal importe;

}
