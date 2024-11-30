package com.proyectosistemaventas.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCreateDTO {

    private String userName;
    private String contrasenia;
    private EmpleadoDTO empleado;
    private RolDTO rol;

}
