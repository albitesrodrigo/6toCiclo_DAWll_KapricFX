package com.proyectosistemaventas.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VentasDTO {

    private Long idVenta;
    private Date fechaVenta;
    private ClienteDTO cliente;
    private EmpleadoDTO empleado;

    private List<DetalleVentaCreateDTO> detalleVentaCreateDTO;

}
