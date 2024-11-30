package com.proyectosistemaventas.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteCreateDTO {

    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String numDocumento;
    private String direccion;
    private String correo;

    private TipoDocumentoDTO tipoDocumento;

}
