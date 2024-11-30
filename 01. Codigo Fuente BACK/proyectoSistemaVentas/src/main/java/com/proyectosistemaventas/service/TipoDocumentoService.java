package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.TipoDocumentoCreateDTO;
import com.proyectosistemaventas.dtos.TipoDocumentoDTO;
import com.proyectosistemaventas.dtos.TipoDocumentoUpdateDTO;

import java.util.List;

public interface TipoDocumentoService {

    List<TipoDocumentoDTO> listarTipoDocumentos();
    TipoDocumentoDTO obtenerTipoDocumentoPorID(long id);
    TipoDocumentoDTO registrarTipoDocumento(TipoDocumentoCreateDTO tipoDocumentoCreateDTO);
    TipoDocumentoDTO actualizarTipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO);
    TipoDocumentoDTO eliminarTipoDocumento(long id);

}
