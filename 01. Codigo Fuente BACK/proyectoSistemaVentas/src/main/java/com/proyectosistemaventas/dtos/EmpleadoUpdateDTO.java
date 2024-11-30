package com.proyectosistemaventas.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmpleadoUpdateDTO {

    private Long idEmpleado;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String numDocumento;
    private String direccion;
    private String correo;
    private Integer telefono;
    private Date fechaNacimiento;

    private TipoDocumentoDTO tipoDocumento;
    private EstadoDTO estado;

}
