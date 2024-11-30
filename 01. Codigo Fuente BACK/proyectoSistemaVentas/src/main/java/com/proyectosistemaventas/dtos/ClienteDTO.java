package com.proyectosistemaventas.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private Long idCliente;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String numDocumento;
    private String direccion;
    private String correo;

    private TipoDocumentoDTO tipoDocumento;
}
